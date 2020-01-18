package com.intellias.px.commands;

import com.intellias.px.annotations.CommandId;
import com.intellias.px.dao.factories.DaoFactory;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandsFinder {
    private DaoFactory daoFactory;

    public CommandsFinder(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @SneakyThrows
    public Command lookup(String id) {
        Reflections reflections = new Reflections("com.intellias.px");
        Set<Class<?>> typesAnnotatedWithCommandId = reflections.getTypesAnnotatedWith(CommandId.class);

        List<Class<?>> foundCommands = typesAnnotatedWithCommandId.stream()
                .filter(aClass -> aClass.getAnnotation(CommandId.class).value().equals(id))
                .filter(aClass -> Command.class.isAssignableFrom(aClass))
                .collect(Collectors.toList());
        if (foundCommands.size() != 1) {
            throw new IllegalStateException(" Size is incorrect");
        }

        Class<?> commandClass = foundCommands.get(0);

        Constructor<?>[] constructors = commandClass.getConstructors();

        Optional<Constructor<?>> mainBeConstructionWithDaoFactory = Arrays.stream(constructors)
                .filter(constructor -> constructor.getParameterTypes().length == 1)
                .filter(constructor -> constructor.getParameterTypes()[0].isAssignableFrom(DaoFactory.class))
                .findFirst();

        if (mainBeConstructionWithDaoFactory.isPresent()) {
            Constructor<?> constructor = mainBeConstructionWithDaoFactory.get();
            return (Command) constructor.newInstance(daoFactory);
        } else {
            Constructor<?> defaultConstructor = Arrays.stream(constructors)
                    .filter(constructor -> constructor.getParameterTypes().length == 0)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("no default constructor"));
            return (Command) defaultConstructor.newInstance();
        }
    }
}

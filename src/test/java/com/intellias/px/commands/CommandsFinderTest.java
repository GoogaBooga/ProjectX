package com.intellias.px.commands;

import com.intellias.px.dao.factories.DaoFactory;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.lang.reflect.Method;

public class CommandsFinderTest {

    private CommandsFinder commandsFinder;

    @Before
    public void setUp() throws Exception {
        commandsFinder = new CommandsFinder(PowerMockito.mock(DaoFactory.class));
    }

    @Test
    public void shouldFindLoginCommand(){
        // execute logic
        Command loginCommand = commandsFinder.lookup("login");


        // verify
//        Class<? extends Command> aClass = loginCommand.getClass();
//        Class<Command> loginCommandClass
        Assert.assertEquals(LoginCommand.class, loginCommand.getClass());
    }

    @Test
    @SneakyThrows
    public void shouldFindRegisterCommand(){
        // execute logic
//        Command registerCommand = commandsFinder.lookup("register");

        Method lookupMethod = CommandsFinder.class.getMethod("lookup", String.class);
        Command registerCommand = (Command)lookupMethod.invoke(commandsFinder, "register");

        // verify
        Assert.assertEquals(RegisterCommand.class, registerCommand.getClass());
    }
}

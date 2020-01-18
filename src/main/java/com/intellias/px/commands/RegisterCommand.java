package com.intellias.px.commands;

import com.intellias.px.annotations.CommandId;
import com.intellias.px.commands.Command;
import com.intellias.px.dao.UserDao;
import com.intellias.px.dao.factories.DaoFactory;
import com.intellias.px.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@CommandId("register")
public class RegisterCommand implements Command {
    private final DaoFactory daoFactory;
    public RegisterCommand(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserDao userDao = daoFactory.createUserDao();
        //String username = request.getPathTranslated("name");
//        Optional<User> user = userDao.create(User.builder().name("test"));
        return "main.jsp";
    }
}

package com.intellias.px.commands;

import com.intellias.px.dao.factories.DaoFactory;
import com.intellias.px.dao.UserDao;
import com.intellias.px.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command{

    private final DaoFactory daoFactory;

    public LoginCommand(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserDao userDao = daoFactory.createUserDao();
        Optional<User> maybeUser = userDao.findByLogin(login);

        if (maybeUser.isPresent()) {
            User user = maybeUser.get();
            if (user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                return "WEB-INF/main.jsp";
            }
        }

        request.setAttribute("errorMsg", "User or password is incorrect");
        return "oups.html";
    }
}

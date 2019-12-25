package com.intellias.px.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command{



    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if ("admin".equals(login) && "admin".equals(password)) {
            request.setAttribute("user", login);
            return "WEB-INF/main.jsp";
        } else {
            return "WEB-INF/login.jsp";
        }
    }
}

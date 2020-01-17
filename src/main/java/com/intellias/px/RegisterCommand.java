package com.intellias.px;

import com.intellias.px.commands.Command;
import com.intellias.px.dao.factories.DaoFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCommand implements Command {
    public RegisterCommand(DaoFactory daoFactory) {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "main.jsp";
    }
}

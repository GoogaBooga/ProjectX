package com.intellias.px;

import com.intellias.px.commands.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandParamValue = req.getParameter("command");

        Command command;
        if ("A".equals(commandParamValue)) {
            command = new Command() {
                public String execute(HttpServletRequest request, HttpServletResponse response) {
                    System.out.println(req.getContextPath());
                    return "index.html";
                }
            };
        } else {
            command = new Command() {
                @Override
                public String execute(HttpServletRequest request, HttpServletResponse response) {
                    System.out.println("Error");
                    return "oups.html";
                }
            };
        }

        String viewName = command.execute(req, resp);

        System.out.println(req.getContextPath());
        RequestDispatcher a = req.getRequestDispatcher(viewName);
        a.forward(req, resp);
    }
}

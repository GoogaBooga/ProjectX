package com.intellias.px;

import com.intellias.px.commands.Command;
import com.intellias.px.commands.LoginCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainServletController extends HttpServlet {

    private static final Map<String, Command> commandIdToCommand = new HashMap<>();

    static {
        commandIdToCommand.put("login", new LoginCommand());
    }

    public MainServletController(){
        commandIdToCommand.put("A", ((request, response) -> {
            System.out.println(request.getServerPort() + request.getContextPath());
            return "index.jsp";
        }));
    }

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
        Command command = commandIdToCommand.getOrDefault(commandParamValue, (lReq, lRes) -> "oups.html");
        String viewName = command.execute(req, resp);
        RequestDispatcher a = req.getRequestDispatcher(viewName);
        a.forward(req, resp);
    }
}

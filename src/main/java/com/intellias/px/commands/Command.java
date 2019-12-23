package com.intellias.px.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface Command {

    String execute(HttpServletRequest request, HttpServletResponse response);

}

package com.intellias.px;

import com.intellias.px.commands.Command;
import com.intellias.px.dao.factories.DaoFactory;
import com.intellias.px.dao.factories.H2DaoFactory;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCommandTest {
    @Test
    public void shouldRegisterUser() {
//        DaoFactory daoFactory = Mockito.mock(DaoFactory.class);
        DaoFactory daoFactory = PowerMockito.mock(DaoFactory.class);

        HttpServletRequest httpServletRequest = PowerMockito.mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = PowerMockito.mock(HttpServletResponse.class);
        Command registerCommand = new RegisterCommand(daoFactory);
        String pageToRedirect = registerCommand.execute(httpServletRequest, httpServletResponse);

        Assert.assertEquals("main.jsp", pageToRedirect);

    }
}

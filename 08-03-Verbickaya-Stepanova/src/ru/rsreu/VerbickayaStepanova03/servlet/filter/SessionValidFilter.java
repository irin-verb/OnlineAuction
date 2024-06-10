package ru.rsreu.VerbickayaStepanova03.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.command.client.CommandEnum;
import ru.rsreu.VerbickayaStepanova03.command.user.LogoutCommand;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.User;
import ru.rsreu.VerbickayaStepanova03.logic.UserLogic;
import ru.rsreu.VerbickayaStepanova03.resource.MessageManager;

public class SessionValidFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		ActionCommand command = (ActionCommand) new LogoutCommand(); 
		String action = httpRequest.getParameter("command");
		String page = null;
		
		if (action != null && !action.isEmpty()) {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			if (currentEnum != CommandEnum.LOGIN && httpRequest.getSession(true).getAttribute("user") == null) {
				request.setAttribute("sessionEndMessage", MessageManager.getProperty("message.sessionEnded"));
				page = command.execute(httpRequest);
				RequestDispatcher dispatcher = httpRequest.getServletContext().getRequestDispatcher(page);
				dispatcher.forward(httpRequest, httpResponse);
			} else {
				User user = UserLogic.getUser((String) httpRequest.getSession(true).getAttribute("user"));
				if (currentEnum != CommandEnum.LOGIN && (user == null || !user.isOnlineStatus())) {
					request.setAttribute("smthgWentWrongMessage", MessageManager.getProperty("message.smthgWentWrong"));
					page = command.execute(httpRequest);
					RequestDispatcher dispatcher = httpRequest.getServletContext().getRequestDispatcher(page);
					dispatcher.forward(httpRequest, httpResponse);
				} else {
					chain.doFilter(request, response);
				}
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
	}
}

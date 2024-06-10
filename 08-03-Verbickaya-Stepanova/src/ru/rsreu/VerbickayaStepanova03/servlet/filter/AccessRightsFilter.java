package ru.rsreu.VerbickayaStepanova03.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
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

public class AccessRightsFilter implements Filter {

	private String indexPath;

	public void init(FilterConfig fConfig) throws ServletException {
		indexPath = fConfig.getInitParameter("INDEX_PATH");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String action = httpRequest.getParameter("command");
		if (action != null && !action.isEmpty()) {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			if (currentEnum != CommandEnum.LOGIN) {
				User user = UserLogic.getUser((String) httpRequest.getSession(true).getAttribute("user"));
				if (!currentEnum.isValidAccessRights(user.getType())) {
					ActionCommand command = new LogoutCommand();
					command.execute(httpRequest);
					RequestDispatcher dispatcher = httpRequest.getServletContext().getRequestDispatcher(indexPath);
					dispatcher.forward(httpRequest, httpResponse);
				} else {
					chain.doFilter(request, response);
				}
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
	}
}

package ru.rsreu.VerbickayaStepanova03.servlet.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.command.user.LogoutCommand;

public class PageRedirectFilter implements Filter {

	private String indexPath;

	public void init(FilterConfig fConfig) throws ServletException {
		indexPath = fConfig.getInitParameter("INDEX_PATH");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		ActionCommand command = (ActionCommand) new LogoutCommand();
		command.execute(httpRequest);
		RequestDispatcher dispatcher = httpRequest.getServletContext().getRequestDispatcher(indexPath);
		dispatcher.forward(httpRequest, httpResponse);

	}

	public void destroy() {
	}
}

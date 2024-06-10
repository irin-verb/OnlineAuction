package ru.rsreu.VerbickayaStepanova03.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.command.factory.ActionFactory;
import ru.rsreu.VerbickayaStepanova03.resource.ConfigurationManager;
import ru.rsreu.VerbickayaStepanova03.resource.MessageManager;
/**
 * The FrontController class extends HttpServlet and serves as the main controller
 * for handling HTTP requests.
 */
public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
     * Handles HTTP GET requests by calling the processRequest method.
     *
     * @param request - the HttpServletRequest object.
     * @param response - the HttpServletResponse object.
     * @throws ServletException - if a servlet-specific error occurs.
     * @throws IOException - if an I/O error occurs.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
     * Handles HTTP POST requests by calling the processRequest method.
     *
     * @param request - the HttpServletRequest object.
     * @param response - the HttpServletResponse object.
     * @throws ServletException - if a servlet-specific error occurs.
     * @throws IOException - if an I/O error occurs.
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
     * Processes the HTTP request by setting character encoding, determining the
     * command from the JSP, and executing the corresponding action command.
     *
     * @param request - the HttpServletRequest object.
     * @param response - the HttpServletResponse object.
     * @throws ServletException - if a servlet-specific error occurs.
     * @throws IOException - if an I/O error occurs.
     */
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String page = null;
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);
		page = command.execute(request);
		if (page != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
			dispatcher.forward(request, response);
		} else {
			page = ConfigurationManager.getProperty("path.page.index");
			request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
			response.sendRedirect(request.getContextPath() + page);
		}
	}
}

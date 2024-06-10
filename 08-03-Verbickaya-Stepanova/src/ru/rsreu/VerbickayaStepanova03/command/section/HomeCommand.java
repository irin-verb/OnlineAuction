package ru.rsreu.VerbickayaStepanova03.command.section;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.resource.ConfigurationManager;

public class HomeCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		request.getSession(true).setAttribute("page", request.getParameter("command"));
		String page = ConfigurationManager.getProperty("path.page.main");
		return page;
	}
}

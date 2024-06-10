package ru.rsreu.VerbickayaStepanova03.command;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.VerbickayaStepanova03.resource.ConfigurationManager;

public class EmptyCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}
}

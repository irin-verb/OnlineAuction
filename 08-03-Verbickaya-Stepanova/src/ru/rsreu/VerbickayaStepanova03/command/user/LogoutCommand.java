package ru.rsreu.VerbickayaStepanova03.command.user;

import javax.servlet.http.HttpServletRequest;
import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.resource.ConfigurationManager;

public class LogoutCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.index");
		request.getSession().invalidate();
		return page;
	}
}

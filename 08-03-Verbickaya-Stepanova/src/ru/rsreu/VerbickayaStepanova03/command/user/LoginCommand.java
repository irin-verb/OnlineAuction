package ru.rsreu.VerbickayaStepanova03.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.enums.UserTypeEnum;
import ru.rsreu.VerbickayaStepanova03.logic.LoginLogic;
import ru.rsreu.VerbickayaStepanova03.logic.UserLogic;
import ru.rsreu.VerbickayaStepanova03.resource.ConfigurationManager;
import ru.rsreu.VerbickayaStepanova03.resource.MessageManager;

public class LoginCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String user = request.getParameter("login");
		String pass = request.getParameter("password");
		if (!LoginLogic.checkLogin(user, pass)) {
			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
			page = ConfigurationManager.getProperty("path.page.login");
		} else if (LoginLogic.checkBlockingStatus(user)) {
			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.blockederror"));
			page = ConfigurationManager.getProperty("path.page.login");
		}
		else {
			page = ConfigurationManager.getProperty("path.page.main");
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			UserTypeEnum userType = UserLogic.getUserType(user);
			session.setAttribute("userType", userType);
			session.setMaxInactiveInterval(60);
			UserLogic.login(user);
		}
		return page;
	}
}

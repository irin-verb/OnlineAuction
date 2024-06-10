package ru.rsreu.VerbickayaStepanova03.command.user;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.command.section.UsersCommand;
import ru.rsreu.VerbickayaStepanova03.logic.UserLogic;
import ru.rsreu.VerbickayaStepanova03.resource.MessageManager;

public class SaveNewUserCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {

		String newLogin = request.getParameter("newUserLogin");
		String newType = request.getParameter("type");
		String newPassword = request.getParameter("password");
		String page = null;
		if (newLogin.equals("") || newPassword.equals("")) {
			ActionCommand command = new NewUserCommand();
			page = command.execute(request);
			request.setAttribute("errorMessage", MessageManager.getProperty("message.emptyFieldsError"));
		} else if (UserLogic.getUser(newLogin) != null) {
			ActionCommand command = new NewUserCommand();
			page = command.execute(request);
			request.setAttribute("errorMessage", MessageManager.getProperty("message.notUniqueLogin"));
		} else {
			ActionCommand command = new UsersCommand();
			UserLogic.addUser(newLogin, newPassword, newType);
			page = command.execute(request);
		}
		return page;
	}
}

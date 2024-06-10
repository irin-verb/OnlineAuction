package ru.rsreu.VerbickayaStepanova03.command.user;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.logic.UserLogic;

public class SaveUserCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {

		ActionCommand command = new OpenUserCommand();

		String userLogin = request.getParameter("userLogin");
		String newPassword = request.getParameter("password");
		String newBlockingStatus = request.getParameter("blockingStatus");

		UserLogic.changeUserData(userLogin, newPassword, newBlockingStatus);

		String page = command.execute(request);
		return page;
	}

}
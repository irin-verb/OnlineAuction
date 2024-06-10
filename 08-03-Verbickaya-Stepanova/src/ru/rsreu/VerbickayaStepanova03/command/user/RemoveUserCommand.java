package ru.rsreu.VerbickayaStepanova03.command.user;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.command.section.UsersCommand;
import ru.rsreu.VerbickayaStepanova03.logic.UserLogic;

public class RemoveUserCommand  implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {

		ActionCommand command = new UsersCommand();

		String userLogin = request.getParameter("userLogin");
		UserLogic.remove(userLogin);

		String page = command.execute(request);
		return page;
	}

}

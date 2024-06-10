package ru.rsreu.VerbickayaStepanova03.command.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.User;
import ru.rsreu.VerbickayaStepanova03.logic.UserLogic;
import ru.rsreu.VerbickayaStepanova03.resource.ConfigurationManager;

public class EditUserCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		
		String filter = request.getParameter("filter");
		request.setAttribute("filter", filter);

		List<User> userList = UserLogic.getUserList(filter);
		request.setAttribute("users", userList);

		String userLogin = request.getParameter("userLogin");
		User openedUser = UserLogic.getUser(userLogin);
		request.setAttribute("openedUser", openedUser);

		String page = ConfigurationManager.getProperty("path.page.editUser");
		return page;
	}
}

package ru.rsreu.VerbickayaStepanova03.command.section;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.command.user.LogoutCommand;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.User;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.enums.UserTypeEnum;
import ru.rsreu.VerbickayaStepanova03.logic.UserLogic;
import ru.rsreu.VerbickayaStepanova03.resource.ConfigurationManager;

public class UsersCommand implements ActionCommand {

	private static List<String> adminFilters = new ArrayList<String>(
			Arrays.asList("All users", "Admins", "Moders", "Normal users", "Authorized", "Unauthorized"));
	private static List<String> moderFilters = new ArrayList<String>(
			Arrays.asList("Normal users", "Blocked", "Not blocked"));

	@Override
	public String execute(HttpServletRequest request) {

		String page;

		request.getSession(true).setAttribute("page", request.getParameter("command"));
		String filter = request.getParameter("filter");

		String login = (String) request.getSession(true).getAttribute("user");
		UserTypeEnum role = UserLogic.getUser(login).getType();
		if ((role.equals(UserTypeEnum.admin) && adminFilters.contains(filter))
				|| (role.equals(UserTypeEnum.moder) && moderFilters.contains(filter))) {
			List<User> userList = UserLogic.getUserList(filter);
			page = ConfigurationManager.getProperty("path.page.users");
			request.setAttribute("filter", filter);
			request.setAttribute("users", userList);
		} else {
			ActionCommand command = new LogoutCommand();
			command.execute(request);
			page = ConfigurationManager.getProperty("path.page.littleError");
		}
		return page;
	}

}
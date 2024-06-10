package ru.rsreu.VerbickayaStepanova03.command.good;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.enums.UserTypeEnum;
import ru.rsreu.VerbickayaStepanova03.logic.GoodLogic;
import ru.rsreu.VerbickayaStepanova03.logic.UserLogic;
import ru.rsreu.VerbickayaStepanova03.resource.MessageManager;

public class SaveGoodCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {

		ActionCommand command = new OpenGoodCommand();
		String user = (String) request.getSession(true).getAttribute("user");
		String id = request.getParameter("goodID");

		if (UserLogic.getUserType(user).equals(UserTypeEnum.user)) {
			String description = request.getParameter("description");
			GoodLogic.changeDescription(id, description);
		} else if (UserLogic.getUserType(user).equals(UserTypeEnum.moder)) {
			String priceStep = request.getParameter("priceStep");
			String sellingInterval = request.getParameter("sellingInterval");
			if (priceStep.equals("") || priceStep.equals("0") || sellingInterval.equals("")
					|| sellingInterval.equals("0")) {
				command = new EditGoodCommand();
				request.setAttribute("errorMessage", MessageManager.getProperty("message.emptySettingsError"));
			} else {
				GoodLogic.changePriceStep(id, priceStep);
				GoodLogic.changeSellingInterval(id, sellingInterval);
			}
		}
		String page = command.execute(request);
		return page;
	}

}
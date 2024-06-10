package ru.rsreu.VerbickayaStepanova03.command.good;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.Good;
import ru.rsreu.VerbickayaStepanova03.logic.GoodLogic;
import ru.rsreu.VerbickayaStepanova03.resource.ConfigurationManager;
import ru.rsreu.VerbickayaStepanova03.resource.MessageManager;

public class SaveNewGoodCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {

		String user = (String) request.getSession(true).getAttribute("user");

		String filter = request.getParameter("filter");
		request.setAttribute("filter", filter);

		List<Good> myGoodList = GoodLogic.getGoodList(filter, user);
		request.setAttribute("goods", myGoodList);

		String goodName = request.getParameter("goodName");
		String goodDescription = request.getParameter("goodDescription");
		String goodCategory = request.getParameter("goodCategory");
		String goodPrice = request.getParameter("goodPrice");
		String goodSeller = user;

		String page;

		if (goodName.trim().equals("") || goodPrice.trim().equals("") || goodPrice.trim().equals("0")) {
			ActionCommand command = new NewGoodCommand();
			page = command.execute(request);
			if (goodPrice.trim().equals("0")) {
				request.setAttribute("errorMessage", MessageManager.getProperty("message.nullPriceError"));
			} else {
				request.setAttribute("errorMessage", MessageManager.getProperty("message.emptyFieldsError"));
			}
		} else {
			GoodLogic.addGood(goodName, goodDescription, goodCategory, goodPrice, goodSeller);
			page = ConfigurationManager.getProperty("path.page.myGoods");
		}
		return page;
	}
}
package ru.rsreu.VerbickayaStepanova03.command.good;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.Good;
import ru.rsreu.VerbickayaStepanova03.logic.GoodLogic;
import ru.rsreu.VerbickayaStepanova03.resource.ConfigurationManager;

public class EditGoodCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		String user = (String) session.getAttribute("user");
		String parentPage = (String) session.getAttribute("page");

		String filter = request.getParameter("filter");
		request.setAttribute("filter", filter);

		if ((parentPage.equals("goods")) || (parentPage.equals("myGoods"))) {
			List<Good> filteredGoodList = GoodLogic.getGoodList(filter, user);
			request.setAttribute("goods", filteredGoodList);
			if (parentPage.equals("goods")) {
				List<String> categoryList = GoodLogic.getCategoryList();
				request.setAttribute("categories", categoryList);
			}
		} else {
			// тут чета для trades /*"trades"*/ и тоже с filter
		}

		String id = request.getParameter("goodID");
		Good good = GoodLogic.getGood(id);
		request.setAttribute("good", good);

		String parentPageName;
		switch (parentPage) {
		case "goods":
			parentPageName = ConfigurationManager.getProperty("name.page.goods");
			break;
		case "myGoods":
			parentPageName = ConfigurationManager.getProperty("name.page.myGoods");
			break;
		case "trades":
			parentPageName = ConfigurationManager.getProperty("name.page.trades");
			break;
		default:
			parentPageName = ConfigurationManager.getProperty("name.page.main");
			break;
		}
		session.setAttribute("parentPage", parentPageName);
		
		String page = ConfigurationManager.getProperty("path.page.editGood");
		return page;
	}

}
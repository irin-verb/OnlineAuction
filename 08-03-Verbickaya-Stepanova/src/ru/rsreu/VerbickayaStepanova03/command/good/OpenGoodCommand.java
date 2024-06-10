package ru.rsreu.VerbickayaStepanova03.command.good;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.Good;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.Trade;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.enums.GoodStatusEnum;
import ru.rsreu.VerbickayaStepanova03.logic.GoodLogic;
import ru.rsreu.VerbickayaStepanova03.logic.TradeLogic;
import ru.rsreu.VerbickayaStepanova03.resource.ConfigurationManager;

public class OpenGoodCommand implements ActionCommand {

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
			List<Trade> filteredTradeList = TradeLogic.getTradeList(filter, user);
			request.setAttribute("trades", filteredTradeList);
		}

		String id = request.getParameter("goodID");
		Good good = GoodLogic.getGood(id);
		request.setAttribute("good", good);

		boolean isMyGood = GoodLogic.isMyGood(id, user);
		request.setAttribute("isMyGood", isMyGood);

		if (good.getStatus().equals(GoodStatusEnum.sold)) {
			String goodOwner = GoodLogic.getGoodOwner(id);
			request.setAttribute("goodOwner", goodOwner);
		}

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
		request.setAttribute("parentPage", parentPageName);

		String page = ConfigurationManager.getProperty("path.page.good");
		return page;
	}
}
package ru.rsreu.VerbickayaStepanova03.logic;

import java.util.List;
import ru.rsreu.VerbickayaStepanova03.command.trade.TradePageTypeEnum;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.Trade;

public class TradeLogic {

	public static Trade getTrade(String tradeId) {
		return DAOLogic.getTradeDAO().getTrade(tradeId);
	}

	public static TradePageTypeEnum getTradePageType(String tradeId, String userLogin) {
		Integer trade = Integer.parseInt(tradeId);
		List<Integer> losingTrades = DAOLogic.getTradeDAO().getLosingTradesId(userLogin);
		List<Integer> winningTrades = DAOLogic.getTradeDAO().getWinningTradesId(userLogin);
		List<Integer> losedTrades = DAOLogic.getTradeDAO().getLosedTradesId(userLogin);
		List<Integer> winnedTrades = DAOLogic.getTradeDAO().getWinnedTradesId(userLogin);
		if (losingTrades.contains(trade)) {
			return TradePageTypeEnum.losingTrade;
		} else if (winningTrades.contains(trade)) {
			return TradePageTypeEnum.winningTrade;
		} else if (losedTrades.contains(trade)) {
			return TradePageTypeEnum.losedTrade;
		} else if (winnedTrades.contains(trade)) {
			return TradePageTypeEnum.winnedTrade;
		} else
			return TradePageTypeEnum.notMyTrade;
	}

	public static List<Trade> getTradeList(String filter, String userLogin) {
		if (filter.equals("All trades")) {
			return DAOLogic.getTradeDAO().getAllTrades(userLogin);
		} else if (filter.equals("Successful")) {
			return DAOLogic.getTradeDAO().getSuccessfulTrades(userLogin);
		} else if (filter.equals("Unsuccessful")) {
			return DAOLogic.getTradeDAO().getUnsuccessfulTrades(userLogin);
		} else
			return null;
	}

}

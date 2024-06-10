package ru.rsreu.VerbickayaStepanova03.logic;

import java.util.List;

import ru.rsreu.VerbickayaStepanova03.datalayer.data.Good;

public class GoodLogic {

	public static List<String> getCategoryList() {
		return DAOLogic.getGoodDAO().getCategories();
	}

	public static List<Good> getGoodList(String filter, String userLogin) {
		if (filter.equals("All goods")) {
			return DAOLogic.getGoodDAO().getAllSellingGoods();
		} else if (filter.equals("Hot goods")) {
			return DAOLogic.getGoodDAO().getSellingHotGoods();
		} else if (GoodLogic.getCategoryList().contains(filter)) {
			return DAOLogic.getGoodDAO().getSellingGoodsByCategory(filter);
		} else if (filter.equals("On sale")) {
			return DAOLogic.getGoodDAO().getMySellingGoods(userLogin);
		} else if (filter.equals("Sold")) {
			return DAOLogic.getGoodDAO().getMySoldGoods(userLogin);
		} else if (filter.equals("Removed from sale")) {
			return DAOLogic.getGoodDAO().getMyRemovedGoods(userLogin);
		} else
			return null;
	}

	public static Good getGood(String goodId) {
		return DAOLogic.getGoodDAO().getGood(goodId);
	}

	public static boolean isMyGood(String goodId, String userLogin) {
		Good good = GoodLogic.getGood(goodId);
		String seller = good.getSeller();
		return seller.equals(userLogin);
	}

	public static String getGoodOwner(String goodId) {
		return DAOLogic.getTradeDAO().getBuyerOfGood(goodId);
	}

	public static void raisePrice(String goodId, String userLogin) {
		DAOLogic.getGoodDAO().raiseGoodPrice(goodId, userLogin);
	}

	public static void removeFromSale(String goodId) {
		DAOLogic.getGoodDAO().removeGood(goodId);
	}

	public static void changeDescription(String goodId, String newDescription) {
		DAOLogic.getGoodDAO().setGoodDescription(goodId, newDescription);
	}

	public static void addGood(String goodName, String goodDescription, String goodCategory, String goodPrice,
			String goodSeller) {
		DAOLogic.getGoodDAO().addGood(goodName, goodDescription, goodCategory, goodPrice, goodSeller);
	}

	public static int getPriceStepSetting() {
		return DAOLogic.getGoodDAO().getPriceStepSetting();
	}

	public static int getSellingIntervalSetting() {
		return DAOLogic.getGoodDAO().getSellingIntervalSetting();
	}

	public static void changeConstants(String priceStep, String sellingInterval) {
		DAOLogic.getGoodDAO().setConstants(priceStep, sellingInterval);
	}

	public static void changePriceStep(String id, String priceStep) {
		DAOLogic.getGoodDAO().setPriceStep(id, priceStep);
	}

	public static void changeSellingInterval(String id, String sellingInterval) {
		DAOLogic.getGoodDAO().setSellinInterval(id, sellingInterval);
	}

}

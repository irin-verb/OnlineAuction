package ru.rsreu.VerbickayaStepanova03.datalayer.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.rsreu.VerbickayaStepanova03.datalayer.GoodDAO;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.Good;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.enums.GoodStatusEnum;
import ru.rsreu.VerbickayaStepanova03.resource.QueryManager;

public class OracleGoodDAO implements GoodDAO {

	private Connection connection;

	public OracleGoodDAO(Connection connection) {
		this.connection = connection;
	}

	private static Good formGoodFromResultSet(ResultSet rs) throws SQLException {
		Good good = new Good(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
				rs.getString("category"), rs.getInt("start_price"), rs.getInt("price"), rs.getInt("price_step"),
				rs.getInt("bet_count"), rs.getDate("creating_date"), rs.getDate("selling_date"),
				rs.getInt("selling_interval"), GoodStatusEnum.toStatus(rs.getString("status")), rs.getString("seller"));
		return good;
	}

	private static List<Good> formListFromResultSet(ResultSet rs) throws SQLException {
		List<Good> goodList = new ArrayList<Good>();
		while (rs.next()) {
			Good good = OracleGoodDAO.formGoodFromResultSet(rs);
			goodList.add(good);
		}
		return goodList;
	}

	@Override
	public List<Good> getAllSellingGoods() {
		List<Good> goodList = new ArrayList<Good>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.allGoods"));
			ResultSet rs = st.executeQuery();
			goodList = OracleGoodDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return goodList;
	}

	@Override
	public List<Good> getSellingHotGoods() {
		List<Good> goodList = new ArrayList<Good>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.hotGoods"));
			ResultSet rs = st.executeQuery();
			goodList = OracleGoodDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return goodList;
	}

	@Override
	public List<Good> getSellingGoodsByCategory(String filter) {
		List<Good> goodList = new ArrayList<Good>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.categoryGoods"));
			st.setString(1, filter);
			ResultSet rs = st.executeQuery();
			goodList = OracleGoodDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return goodList;
	}

	@Override
	public List<Good> getMySellingGoods(String login) {
		List<Good> goodList = new ArrayList<Good>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.sellingGoods"));
			st.setString(1, login);
			ResultSet rs = st.executeQuery();
			goodList = OracleGoodDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return goodList;
	}

	@Override
	public List<Good> getMySoldGoods(String login) {
		List<Good> goodList = new ArrayList<Good>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.soldGoods"));
			st.setString(1, login);
			ResultSet rs = st.executeQuery();
			goodList = OracleGoodDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return goodList;
	}

	@Override
	public List<Good> getMyRemovedGoods(String login) {
		List<Good> goodList = new ArrayList<Good>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.removedGoods"));
			st.setString(1, login);
			ResultSet rs = st.executeQuery();
			goodList = OracleGoodDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return goodList;
	}

	@Override
	public List<String> getCategories() {
		List<String> categoriesList = new ArrayList<String>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.categories"));
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String category = rs.getString("category");
				categoriesList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return categoriesList;
	}

	@Override
	public Good getGood(String id) {
		PreparedStatement st = null;
		Good good = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.good"));
			st.setInt(1, Integer.parseInt(id));
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				good = OracleGoodDAO.formGoodFromResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return good;
	}

	@Override
	public void raiseGoodPrice(String id, String login) {
		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		PreparedStatement st3 = null;
		PreparedStatement st4 = null;
		try {
			int goodId = Integer.parseInt(id);

			st1 = this.connection.prepareStatement(QueryManager.getProperty("query.raisePrice1"));
			st2 = this.connection.prepareStatement(QueryManager.getProperty("query.raisePrice2"));
			st3 = this.connection.prepareStatement(QueryManager.getProperty("query.raisePrice3"));
			st4 = this.connection.prepareStatement(QueryManager.getProperty("query.raisePrice4"));

			st1.setInt(1, goodId);
			st2.setString(1, login);
			st2.setInt(2, goodId);
			st3.setInt(1, goodId);
			st3.setInt(2, goodId);
			st3.setString(3, login);
			st4.setInt(1, goodId);

			st1.executeUpdate();
			st2.executeUpdate();
			st3.executeUpdate();
			st4.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st1.close();
				st2.close();
				st3.close();
				st4.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void removeGood(String id) {
		PreparedStatement st = null;
		try {
			int goodId = Integer.parseInt(id);
			st = this.connection.prepareStatement(QueryManager.getProperty("query.remove"));
			st.setInt(1, goodId);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setGoodDescription(String id, String description) {
		PreparedStatement st = null;
		try {
			int goodId = Integer.parseInt(id);
			st = this.connection.prepareStatement(QueryManager.getProperty("query.setDescription"));
			st.setString(1, description);
			st.setInt(2, goodId);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addGood(String name, String description, String category, String price, String seller) {
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.newGood"));
			st.setString(1, name);
			st.setString(2, description);
			st.setString(3, category);
			st.setInt(4, Integer.parseInt(price));
			st.setInt(5, Integer.parseInt(price));
			st.setString(6, seller);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setConstants(String priceStep, String sellingInterval) {
		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		PreparedStatement st3 = null;
		PreparedStatement st4 = null;
		try {
			st1 = this.connection.prepareStatement(QueryManager.getProperty("query.newSettings1"));
			st2 = this.connection.prepareStatement(QueryManager.getProperty("query.newSettings2"));
			st3 = this.connection.prepareStatement(QueryManager.getProperty("query.newSettings3"));
			st4 = this.connection.prepareStatement(QueryManager.getProperty("query.newSettings4"));
			st2.setInt(1, Integer.parseInt(priceStep));
			st4.setInt(1, Integer.parseInt(sellingInterval));
			st1.executeUpdate();
			st2.executeUpdate();
			st3.executeUpdate();
			st4.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st1.close();
				st2.close();
				st3.close();
				st4.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int getPriceStepSetting() {
		int step = 0;
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.priceStepSetting"));
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				step = rs.getInt("step");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return step;
	}

	@Override
	public int getSellingIntervalSetting() {
		int interval = 0;
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.sellingInteervalSetting"));
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				interval = rs.getInt("interv");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return interval;
	}

	@Override
	public void setPriceStep(String id, String priceStep) {
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.setPriceStep"));
			st.setInt(1, Integer.parseInt(priceStep));
			st.setInt(2, Integer.parseInt(id));
			st.executeUpdate();
			// this.connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setSellinInterval(String id, String sellingInterval) {
		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		PreparedStatement st3 = null;
		PreparedStatement st4 = null;
		try {
			st1 = this.connection.prepareStatement(QueryManager.getProperty("query.setSellingInterval1"));
			st2 = this.connection.prepareStatement(QueryManager.getProperty("query.setSellingInterval2"));
			st3 = this.connection.prepareStatement(QueryManager.getProperty("query.setSellingInterval3"));
			st4 = this.connection.prepareStatement(QueryManager.getProperty("query.setSellingInterval4"));

			st1.setInt(1, Integer.parseInt(sellingInterval));
			st1.setInt(2, Integer.parseInt(id));
			st2.setInt(1, Integer.parseInt(id));
			st3.setInt(1, Integer.parseInt(id));
			st4.setInt(1, Integer.parseInt(id));

			st1.executeUpdate();
			st4.executeUpdate();
			st2.executeUpdate();
			st3.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st1.close();
				st2.close();
				st3.close();
				st4.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

package ru.rsreu.VerbickayaStepanova03.datalayer.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.rsreu.VerbickayaStepanova03.datalayer.TradeDAO;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.Trade;
import ru.rsreu.VerbickayaStepanova03.resource.QueryManager;

public class OracleTradeDAO implements TradeDAO {

	private Connection connection;

	public OracleTradeDAO(Connection connection) {
		this.connection = connection;
	}

	private static Trade formTradeFromResultSet(ResultSet rs) throws SQLException {
		Trade trade = new Trade(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
				rs.getDate("datetime"), rs.getInt("price"), rs.getInt("final_price"), rs.getInt("product"),
				rs.getString("buyer"));
		return trade;
	}

	private static List<Trade> formListFromResultSet(ResultSet rs) throws SQLException {
		List<Trade> tradeList = new ArrayList<Trade>();
		while (rs.next()) {
			Trade trade = OracleTradeDAO.formTradeFromResultSet(rs);
			tradeList.add(trade);
		}
		return tradeList;
	}

	@Override
	public String getBuyerOfGood(String id) {
		PreparedStatement st = null;
		String buyer = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.buyer"));
			st.setInt(1, Integer.parseInt(id));
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				buyer = rs.getString("buyer");
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
		return buyer;
	}

	@Override
	public List<Trade> getAllTrades(String login) {
		List<Trade> tradeList = new ArrayList<Trade>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.allTrades"));
			st.setString(1, login);
			ResultSet rs = st.executeQuery();
			tradeList = OracleTradeDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tradeList;
	}

	@Override
	public List<Trade> getSuccessfulTrades(String login) {
		List<Trade> tradeList = new ArrayList<Trade>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.successfulTrades"));
			st.setString(1, login);
			ResultSet rs = st.executeQuery();
			tradeList = OracleTradeDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tradeList;
	}

	@Override
	public List<Trade> getUnsuccessfulTrades(String login) {
		List<Trade> tradeList = new ArrayList<Trade>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.unsuccessfulTrades"));
			st.setString(1, login);
			ResultSet rs = st.executeQuery();
			tradeList = OracleTradeDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tradeList;
	}

	@Override
	public Trade getTrade(String id) {
		Trade trade = null;
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.trade"));
			st.setInt(1, Integer.parseInt(id));
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				trade = OracleTradeDAO.formTradeFromResultSet(rs);
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
		return trade;
	}

	@Override
	public List<Integer> getLosingTradesId(String login) {
		List<Integer> tradeList = new ArrayList<Integer>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.losingTrades"));
			st.setString(1, login);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				tradeList.add(rs.getInt("id"));
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
		return tradeList;
	}

	@Override
	public List<Integer> getWinningTradesId(String login) {
		List<Integer> tradeList = new ArrayList<Integer>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.winningTrades"));
			st.setString(1, login);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				tradeList.add(rs.getInt("id"));
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
		return tradeList;
	}

	@Override
	public List<Integer> getWinnedTradesId(String login) {
		List<Integer> tradeList = new ArrayList<Integer>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.winnedTrades"));
			st.setString(1, login);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				tradeList.add(rs.getInt("id"));
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
		return tradeList;
	}

	@Override
	public List<Integer> getLosedTradesId(String login) {
		List<Integer> tradeList = new ArrayList<Integer>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.losedTrades"));
			st.setString(1, login);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				tradeList.add(rs.getInt("id"));
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
		return tradeList;
	}

}

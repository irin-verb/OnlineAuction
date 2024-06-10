package ru.rsreu.VerbickayaStepanova03.datalayer.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.rsreu.VerbickayaStepanova03.datalayer.UserDAO;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.User;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.enums.UserTypeEnum;
import ru.rsreu.VerbickayaStepanova03.resource.QueryManager;

public class OracleUserDAO implements UserDAO {

	private Connection connection;

	public OracleUserDAO(Connection connection) {
		this.connection = connection;
	}

	private static User formUserFromResultSet(ResultSet rs) throws SQLException {
		boolean online_status = false;
		boolean blocking_status = false;
		if (rs.getString("online_status").equals("1")) {
			online_status = true;
		}
		if (rs.getString("blocking_status").equals("1")) {
			blocking_status = true;
		}
		User user = new User(rs.getString("login"), rs.getString("parole"), UserTypeEnum.toType(rs.getString("type")),
				online_status, blocking_status);
		return user;
	}

	private static List<User> formListFromResultSet(ResultSet rs) throws SQLException {
		List<User> userList = new ArrayList<User>();
		while (rs.next()) {
			User user = OracleUserDAO.formUserFromResultSet(rs);
			userList.add(user);
		}
		return userList;
	}

	@Override
	public User getUser(String login) {
		User user = null;
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.user"));
			st.setString(1, login);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				user = OracleUserDAO.formUserFromResultSet(rs);
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
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.allUsers"));
			ResultSet rs = st.executeQuery();
			userList = OracleUserDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}

	@Override
	public List<User> getAdminUsers() {
		List<User> userList = new ArrayList<User>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.admins"));
			ResultSet rs = st.executeQuery();
			userList = OracleUserDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}

	@Override
	public List<User> getModerUsers() {
		List<User> userList = new ArrayList<User>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.moders"));
			ResultSet rs = st.executeQuery();
			userList = OracleUserDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}

	@Override
	public List<User> getNormalUsers() {
		List<User> userList = new ArrayList<User>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.users"));
			ResultSet rs = st.executeQuery();
			userList = OracleUserDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}

	@Override
	public List<User> getAuthorizedUsers() {
		List<User> userList = new ArrayList<User>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.onlineUsers"));
			ResultSet rs = st.executeQuery();
			userList = OracleUserDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}

	@Override
	public List<User> getUnauthorizedUsers() {
		List<User> userList = new ArrayList<User>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.offlineUsers"));
			ResultSet rs = st.executeQuery();
			userList = OracleUserDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}

	@Override
	public List<User> getBlockedUsers() {
		List<User> userList = new ArrayList<User>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.blockedUsers"));
			ResultSet rs = st.executeQuery();
			userList = OracleUserDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}

	@Override
	public List<User> getNotBlockedUsers() {
		List<User> userList = new ArrayList<User>();
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.notBlockedUsers"));
			ResultSet rs = st.executeQuery();
			userList = OracleUserDAO.formListFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}

	@Override
	public void block(String login) {
		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		PreparedStatement st3 = null;
		try {
			st1 = this.connection.prepareStatement(QueryManager.getProperty("query.block1"));
			st2 = this.connection.prepareStatement(QueryManager.getProperty("query.block2"));
			st3 = this.connection.prepareStatement(QueryManager.getProperty("query.block3"));
			st1.setString(1, login);
			st2.setString(1, login);
			st3.setString(1, login);
			st1.executeUpdate();
			st2.executeUpdate();
			st3.executeUpdate();
			this.logout(login);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st1.close();
				st2.close();
				st3.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void unblock(String login) {
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.unblock"));
			st.setString(1, login);
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
	public void changeBlockingStatus(String login) {
		boolean status = this.getUser(login).isBlockingStatus();
		if (status) {
			this.unblock(login);
		} else {
			this.block(login);
		}
	}

	@Override
	public void addUser(String login, String password, String type) {
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.newUser"));
			st.setString(1, login);
			st.setString(2, password);
			st.setString(3, type);
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
	public void setUser(String login, String newPassword, String newBlockingStatus) {
		PreparedStatement st = null;
		if (newBlockingStatus.contentEquals("true")) {
			this.block(login);
		} else {
			this.unblock(login);
		}
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.setPassword"));
			st.setString(1, newPassword);
			st.setString(2, login);
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
	public void deleteUser(String login) {
		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		PreparedStatement st3 = null;
		PreparedStatement st4 = null;
		PreparedStatement st5 = null;

		try {
			st1 = this.connection.prepareStatement(QueryManager.getProperty("query.deleteUser1"));
			st2 = this.connection.prepareStatement(QueryManager.getProperty("query.deleteUser2"));
			st3 = this.connection.prepareStatement(QueryManager.getProperty("query.deleteUser3"));
			st4 = this.connection.prepareStatement(QueryManager.getProperty("query.deleteUser4"));
			st5 = this.connection.prepareStatement(QueryManager.getProperty("query.deleteUser5"));

			st1.setString(1, login);
			st2.setString(1, login);
			st3.setString(1, login);
			st4.setString(1, login);
			st5.setString(1, login);

			st1.executeUpdate();
			st2.executeUpdate();
			st3.executeUpdate();
			st4.executeUpdate();
			st5.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st1.close();
				st2.close();
				st3.close();
				st4.close();
				st5.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void logout(String login) {
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.logout"));
			st.setString(1, login);
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
	public void login(String login) {
		PreparedStatement st = null;
		try {
			st = this.connection.prepareStatement(QueryManager.getProperty("query.login"));
			st.setString(1, login);
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

}

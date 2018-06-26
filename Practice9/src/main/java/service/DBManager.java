package service;

import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DBManager {

    private static DBManager instance;

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {
    }

    private static final String CONNECTION_URL = ResourceBundle.getBundle("database").getString("connection_url");

    private static final String SQL_FIND_USER_BY_LOGIN_AND_PASSWORD =
            ResourceBundle.getBundle("database").getString("find_user_by_login_and_password");

    public List<User> findUserByLoginAndPassword(String login, String password) {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = selectQuery(SQL_FIND_USER_BY_LOGIN_AND_PASSWORD, new String[]{login, password});
        if (resultSet == null) {
            return new ArrayList<>();
        }
        try {
            while (resultSet.next()) {
                users.add(extractUser(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private ResultSet selectQuery(String query, String[] attributes) {
        Connection con;
        PreparedStatement stmt;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(CONNECTION_URL);
            stmt = con.prepareStatement(query);
            int count = 1;
            for (String attribute : attributes) {
                stmt.setString(count++, attribute);
            }
            rs = stmt.executeQuery();

        } catch (SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    private void close(Connection cn) {
        if (cn != null) {
            try {
                cn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void close(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setRoleId(rs.getInt("role_id"));
        return user;
    }

}

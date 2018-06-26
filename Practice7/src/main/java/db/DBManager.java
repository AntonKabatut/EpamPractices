package db;

import entity.Group;
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


    private static final String SQL_FIND_ALL_USERS = ResourceBundle.getBundle("queries").getString("find_all_users");

    private static final String SQL_FIND_ALL_GROUPS = ResourceBundle.getBundle("queries").getString("find_all_groups");

    private static final String SQL_INSERT_USER = ResourceBundle.getBundle("queries").getString("insert_user");

    private static final String SQL_INSERT_GROUP = ResourceBundle.getBundle("queries").getString("insert_group");


    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = selectQuery(SQL_FIND_ALL_USERS);
        try {
            while (resultSet.next()) {
                users.add(extractUser(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<Group> findAllGroups() {
        List<Group> groups = new ArrayList<>();
        ResultSet resultSet = selectQuery(SQL_FIND_ALL_GROUPS);
        try {
            while (resultSet.next()) {
                groups.add(extractGroup(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }

    public int insertUser(String login) {
        return insertQuery(SQL_INSERT_USER, login);
    }

    public int insertGroup(String name) {
        return insertQuery(SQL_INSERT_GROUP, name);
    }

    private int insertQuery(String query, String attribute) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        int generateId = 0;

        try {
            connection = DriverManager.getConnection(CONNECTION_URL);
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, attribute);
            preparedStatement.executeUpdate();

            rs = preparedStatement.getGeneratedKeys();
            rs.next();
            generateId = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generateId;
    }

    private ResultSet selectQuery(String query) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(CONNECTION_URL);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
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
        return user;
    }

    private Group extractGroup(ResultSet rs) throws SQLException {
        Group group = new Group();
        group.setId(rs.getInt("id"));
        group.setName(rs.getString("name"));
        return group;
    }

}

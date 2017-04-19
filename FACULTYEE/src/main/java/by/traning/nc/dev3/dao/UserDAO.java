package by.traning.nc.dev3.dao;

import by.traning.nc.dev3.beans.User;
import by.traning.nc.dev3.connectionpool.ConnectionPool;
import by.traning.nc.dev3.dao.DAOImpl.UserDAOImpl;
import by.traning.nc.dev3.filters.NamesTable;
import by.traning.nc.dev3.finals.SqlRequests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 11.04.2017.
 */
public class UserDAO implements GenericDAO<User> {

    @Override
    public List<User> findAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_STUD);
        ResultSet resultSet = statement.executeQuery();
        List<User> userList = new ArrayList<>();

        while(resultSet.next()){
            User user = new User();
            user.setFirstName(resultSet.getString(NamesTable.USER_FIRST_NAME));
            user.setLastName(resultSet.getString(NamesTable.USER_LAST_NAME));
            user.setLogin(resultSet.getString(NamesTable.USER_LOGIN));
            userList.add(user);
        }

        ConnectionPool.INSTANCE.initConnection(connection);
        return userList;
    }



    @Override
    public void create(User entity) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_STUDENT);
        statement.setString(1, entity.getFirstName());
        statement.setString(2, entity.getLastName());
        statement.setString(3, entity.getLogin());
        statement.setString(4, entity.getPassword());
        statement.setInt(5, entity.getRoleId());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.initConnection(connection);
    }

    @Override
    public void delete(User entity) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.DELETE_USER);
        statement.setInt(1, entity.getUserId());
    }

    @Override
    public void update(User entity) throws SQLException {
            Connection connection = ConnectionPool.INSTANCE.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlRequests.UPDATE_USER);
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getLogin());
            statement.setString(4, entity.getPassword());
            statement.setInt(5, entity.getUserId());
            statement.executeUpdate();
            ConnectionPool.INSTANCE.initConnection(connection);
        }



    @Override
    public User find(int id) {
        return null;
    }

    public boolean isAuth(String login, String password) throws SQLException{
        boolean isLogin = false;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.IS_AUTH);
        statement.setString(1,login);
        statement.setString(2,password);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            isLogin = true;
        }
        ConnectionPool.INSTANCE.initConnection(connection);
        return isLogin;
    }

    public User getUserByLogin(String login) throws SQLException{
        User user = new User();
        System.out.println("user?"+user);
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_USER_BY_LOGIN);
        statement.setString(1, login);
        ResultSet result = statement.executeQuery();
        System.out.println("________________________________________"+login);
        while(result.next()){
          // User user = new User();
            user.setUserId(result.getInt(NamesTable.USER_ID));
            System.out.println("________________________________________"+NamesTable.USER_ID);
            user.setFirstName(result.getString(NamesTable.USER_FIRST_NAME));
            user.setLastName(result.getString(NamesTable.USER_LAST_NAME));
            user.setLogin(result.getString(NamesTable.USER_LOGIN));
            user.setPassword(result.getString(NamesTable.USER_PASSWORD));
            user.setRoleId(result.getInt(NamesTable.ROLE_ID));
        }
        ConnectionPool.INSTANCE.initConnection(connection);
        System.out.println("_________________+_______________________"+login);
        System.out.println("__________________++______________________"+user);
        return user;
    }


    public int getUserIdByName(String name) {
        int user_id = 0;
        try {
            Connection connection = ConnectionPool.INSTANCE.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_USER_ID);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                user_id = result.getInt("user_id");
            }
            ConnectionPool.INSTANCE.initConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user_id;
    }

    public String checkRole(String login, String password) throws SQLException {
        String role = null;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.CHECK_ROLE);
        statement.setString(1,login);
        statement.setString(2,password);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            role = resultSet.getString("role_name");
        }
        ConnectionPool.INSTANCE.initConnection(connection);
        return role;
    }

    public int GetRoleById() throws SQLException {
        int role_id = 0;

        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ID_ROLE);
        statement.setString(1, "student");
        ResultSet resultSet = statement.executeQuery();
        if( resultSet.next()){
            role_id = resultSet.getInt("role_id");
        }
        ConnectionPool.INSTANCE.initConnection(connection);

        return role_id;

    }



    public int getFacultyIdByName(String name) throws SQLException {
        int id_faculty = 0;

        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ID_FACULTY);
        statement.setString(1, name);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            id_faculty = result.getInt("faculty_id");
        }
        ConnectionPool.INSTANCE.initConnection(connection);

        return id_faculty;
    }



}

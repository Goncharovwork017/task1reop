package by.traning.nc.dev3.dao;

import by.traning.nc.dev3.beans.Course;
import by.traning.nc.dev3.beans.SheetList;
import by.traning.nc.dev3.beans.User;
import by.traning.nc.dev3.beans.UserSHeetlist;
import by.traning.nc.dev3.connectionpool.ConnectionPool;
import by.traning.nc.dev3.dao.DAOImpl.SheetListDAOImpl;
import by.traning.nc.dev3.finals.NamesTable;
import by.traning.nc.dev3.finals.SqlRequests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 16.04.2017.
 */
public class SheetListDAO implements SheetListDAOImpl<SheetList> {
    @Override
    public  List<SheetList> findAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_SHEETLIST);
        ResultSet resultSet = statement.executeQuery();
        List<SheetList> sheetList = new ArrayList<>();

        while(resultSet.next()){
            SheetList sheet = new SheetList();
            sheet.setId(resultSet.getInt(NamesTable.SHEET_ID));
            sheet.setIdStudent(resultSet.getInt(NamesTable.SHEET_USER));
            sheet.setIdCourse(resultSet.getInt(NamesTable.SHEET_COURSE));
            sheet.setScore(resultSet.getInt(NamesTable.SHEET_SCORE));
            sheet.setShortComment(resultSet.getString(NamesTable.SHEET_COMM));
            sheetList.add(sheet);
        }

        ConnectionPool.INSTANCE.initConnection(connection);
        return sheetList;
    }

    @Override
    public void createEntity(SheetList sheetList) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_SHEETLIST);
        statement.setInt(1, sheetList.getIdStudent());
        statement.setInt(2, sheetList.getIdCourse());
        statement.setInt(3, sheetList.getScore());
        statement.setString(4, sheetList.getShortComment());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.initConnection(connection);
    }



    public List<UserSHeetlist>  findStudentWithEndedCourse(int idCourse) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.FIND_ALL_STUDENT_FOR_COURSE);
        statement.setString(1, String.valueOf(idCourse));
        ResultSet resultSet = statement.executeQuery();
        List<UserSHeetlist> userSHeetlists = new ArrayList<>();

        try{
        while (resultSet.next()) {

            UserSHeetlist sheetList = new UserSHeetlist();
            sheetList.setSheetId(resultSet.getInt(NamesTable.SHEET_ID));
            sheetList.setIdStudent(resultSet.getInt(NamesTable.SHEET_USER));
            sheetList.setScore(resultSet.getInt(NamesTable.SHEET_SCORE));
            sheetList.setShortComment(resultSet.getString(NamesTable.SHEET_COMM));
            sheetList.setFirstName(resultSet.getString(NamesTable.USER_FIRST_NAME));
            sheetList.setLastName(resultSet.getString(NamesTable.USER_LAST_NAME));
            userSHeetlists.add(sheetList);



        }
            ConnectionPool.INSTANCE.initConnection(connection);
    }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return userSHeetlists;
    }



    @Override
    public SheetList getEntityById(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(SheetList sheetList) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.SHEET_UPDATE);
        statement.setInt(1,sheetList.getScore());
        statement.setString(2,sheetList.getShortComment());
        statement.setInt(3 ,sheetList.getSheetId());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.initConnection(connection);
    }
}

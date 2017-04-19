package by.traning.nc.dev3.dao;

import by.traning.nc.dev3.beans.SheetList;
import by.traning.nc.dev3.connectionpool.ConnectionPool;
import by.traning.nc.dev3.dao.DAOImpl.SheetListDAOImpl;
import by.traning.nc.dev3.filters.NamesTable;
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
    public void createEntity(SheetList entity) throws SQLException {

    }

    @Override
    public SheetList getEntityById(int id) throws SQLException {
        return null;
    }
}

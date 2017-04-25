package by.traning.nc.dev3.dao.DAOImpl;

import by.traning.nc.dev3.beans.Entity;
import by.traning.nc.dev3.beans.SheetList;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 19.04.2017.
 */
public interface SheetListDAOImpl<T extends SheetList> {
    List<T> findAll() throws SQLException;

    public void createEntity(T entity) throws SQLException;

    public T getEntityById(int id) throws SQLException;
    void update(T entity) throws SQLException;
}

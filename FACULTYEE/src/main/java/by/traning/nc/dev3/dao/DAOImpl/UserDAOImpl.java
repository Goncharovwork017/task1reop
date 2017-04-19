package by.traning.nc.dev3.dao.DAOImpl;

import by.traning.nc.dev3.beans.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 19.04.2017.
 */
public interface UserDAOImpl<T extends Entity>  {

    List<T> findAll() throws SQLException;

    public void createEntity(T entity) throws SQLException;

    public T getEntityById(int id) throws SQLException;

    public boolean delete(T entity) throws  SQLException;
}

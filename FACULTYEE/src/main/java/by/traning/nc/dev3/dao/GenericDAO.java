package by.traning.nc.dev3.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 19.04.2017.
 */
public interface GenericDAO<E> {
///////////пример
    void create(E entity) throws SQLException;
    void delete(E entity) throws SQLException;
    void update(E entity) throws SQLException;
    E find(int id);
    List<E> findAll() throws SQLException;
}


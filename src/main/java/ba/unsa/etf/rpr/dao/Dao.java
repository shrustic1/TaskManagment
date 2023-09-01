package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.exceptions.MyException;

public interface Dao<T> {
    T getById(int id) throws MyException;

    T add(T item) throws MyException;
    T update(T item) throws MyException;
}

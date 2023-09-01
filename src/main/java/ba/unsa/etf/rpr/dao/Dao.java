package ba.unsa.etf.rpr.dao;

public interface Dao<T> {
    T getById(int id) throws MyException;
}

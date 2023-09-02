package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public interface UserDao extends Dao<User>{
    List<User> searchByName(String name) throws MyException;
}

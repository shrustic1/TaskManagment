package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Tag;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public class UserManager {
    public void add (User user) throws MyException {
        DaoFactory.userDao().add(user);
    }
    public void delete(int id) throws MyException{
        DaoFactory.userDao().delete(id);
    }
    public void update(User user) throws MyException{
        DaoFactory.userDao().update(user);
    }
    public List<User> getAll() throws MyException{
        return DaoFactory.userDao().getAll();
    }

}

package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.exceptions.MyException;
import ba.unsa.etf.rpr.domain.Tag;

import java.util.List;

public class TagManager {
    public void add (Tag tag) throws MyException {
        DaoFactory.tagDao().add(tag);
    }
    public void delete(int id) throws MyException{
        DaoFactory.tagDao().delete(id);
    }
    public void update(Tag tag) throws MyException{
        DaoFactory.tagDao().update(tag);
    }
    public List<Tag> getAll() throws MyException{
        return DaoFactory.tagDao().getAll();
    }
}

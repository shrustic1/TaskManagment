package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Tag;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public class TagManager {

    public List<Tag> getAll() throws MyException {
        return DaoFactory.tagDao().getAll();
    }

    public void delete(int id) throws MyException {
        DaoFactory.tagDao().delete(id);
    }

    public Tag update(Tag tag) throws MyException {
        return DaoFactory.tagDao().update(tag);
    }

    public Tag add(Tag tag) throws MyException {
        return DaoFactory.tagDao().add(tag);
    }

    public void validateTagName(String name) throws MyException{
        if (name == null || name.length() > 45 || name.length() < 3){
            throw new MyException("Tag name must be between 3 and 45 chars");
        }
    }
}

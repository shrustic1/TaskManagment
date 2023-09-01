package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public class TaskManager {
    public void add (Task task) throws MyException {
        DaoFactory.taskDao().add(task);
    }

}

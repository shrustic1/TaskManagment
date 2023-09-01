package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public interface TaskDao extends Dao<Task>{

    List<Task> searchByStatus(String status) throws MyException;
}

package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Tag;
import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class TaskDaoSQLImpl extends AbstractDao<Task> implements TaskDao{
    private static TaskDaoSQLImpl instance = null;
    private TaskDaoSQLImpl(){super("Tasks");}

    public static TaskDao getInstance() {
        if (instance == null) instance = new TaskDaoSQLImpl();
        return instance;
    }

    @Override
    public Task row2object(ResultSet rs) throws MyException {
        try {
            Task task = new Task();
            task.setId(rs.getInt("id"));
            task.setTitle(rs.getString("title"));
            task.setDescription(rs.getString("description"));
            task.setDate(rs.getDate("date"));
            task.setDeadline(rs.getDate("deadline"));
            task.setStatus(rs.getString("status"));
            task.setReporter(DaoFactory.userDao().getById(rs.getInt("reporter_id")));
            task.setAssignee(DaoFactory.userDao().getById(rs.getInt("assignee_id")));
            task.setTag(DaoFactory.tagDao().getById(rs.getInt("tag_id")));
            return task;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }

}

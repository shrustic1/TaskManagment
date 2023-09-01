package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Tag;
import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
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
    @Override
    public Map<String, Object> object2row(Task object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("title", object.getTitle());
        item.put("description", object.getDescription());
        item.put("date", object.getDate());
        item.put("deadline", object.getDeadline());
        item.put("status", object.getStatus());
        item.put("reporter_id", object.getReporter().getId());
        item.put("assignee_id", object.getAssignee().getId());
        item.put("tag_id", object.getTag().getId());
        return item;
    }
    @Override
    public List<Task> searchByStatus(String status) throws MyException{
        return executeQuery("SELECT * FROM Tasks WHERE status = ?", new Object[]{status});
    }
    @Override
    public List<Task> searchByTitle(String title) throws MyException{
        return executeQuery("SELECT * FROM Tasks WHERE title = ?", new Object[]{title});
    }
    @Override
    public List<Task> searchByDeadline(Date deadline) throws MyException{
        return executeQuery("SELECT * FROM Tasks WHERE deadline = ?", new Object[]{deadline});
    }
}

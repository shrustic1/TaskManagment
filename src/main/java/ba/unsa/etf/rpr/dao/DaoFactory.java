package ba.unsa.etf.rpr.dao;

import java.util.List;

public class DaoFactory {

    private static final TagDao tagDao = TagDaoSQLImpl.getInstance();
    private static final UserDao userDao = UserDaoSQLImpl.getInstance();
    private static final TaskDao taskDao = TaskDaoSQLImpl.getInstance();
    private DaoFactory(){
    }

    public static TagDao tagDao(){
        return tagDao;
    }

    public static UserDao userDao(){
        return userDao;
    }

    public static TaskDao taskDao(){
        return taskDao;
    }

}

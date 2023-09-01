package ba.unsa.etf.rpr.dao;

public class DaoFactory {
    private static final UserDao userDao = UserDaoSQLImpl.getInstance();
    private static final TaskDao taskDao = TaskDaoSQLImpl.getInstance();
    private static final TagDao tagDao = TagDaoSQLImpl.getInstance();

    private DaoFactory(){}
    public static TagDao tagDao(){return tagDao;}
    public static UserDao userDao(){return userDao;}
    public static TaskDao taskDao(){return taskDao;}
}

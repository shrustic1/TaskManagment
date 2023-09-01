package ba.unsa.etf.rpr.dao;

public class DaoFactory {
    private static final UserDao userDao = UserDaoSQLImpl.getInstance();
    private static final TaskDao taskDao = TaskDaoSQLImpl.getInstance();
    private static final TagDao tagDao = TagDaoSQLImpl.getInstance();

}

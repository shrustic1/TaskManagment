package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Tag;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{
    private static UserDaoSQLImpl instance = null;
    private UserDaoSQLImpl(){super("Users");}

    public static UserDao getInstance() {
        if (instance == null) instance = new UserDaoSQLImpl();
        return instance;
    }

    @Override
    public User row2object(ResultSet rs) throws MyException {
        try {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }
    @Override
    public Map<String, Object> object2row(User object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("name", object.getName());
        item.put("surname", object.getSurname());
        item.put("email", object.getEmail());
        item.put("password", object.getPassword());
        return item;
    }
    @Override
    public List<User> searchByName(String name) throws MyException{
        return executeQuery("SELECT * FROM Users WHERE name = ?", new Object[]{name});
    }
}

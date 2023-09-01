package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Tag;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TagDaoSQLImpl extends AbstractDao<Tag> implements TagDao{
    private static TagDaoSQLImpl instance = null;
    private TagDaoSQLImpl(){super("Tags");}

    public static TagDao getInstance() {
        if (instance == null) instance = new TagDaoSQLImpl();
        return instance;
    }

    @Override
    public Tag row2object(ResultSet rs) throws MyException {
        try {
            Tag tag = new Tag();
            tag.setId(rs.getInt("id"));
            tag.setName(rs.getString("name"));
            return tag;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }
}

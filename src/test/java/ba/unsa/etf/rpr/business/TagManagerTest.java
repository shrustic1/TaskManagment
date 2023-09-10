package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.TagDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Tag;

import java.util.List;

public class TagManagerTest {
    private TagManager tagManager;
    private Tag tag;
    private TagDaoSQLImpl tagDaoSQLMock;
    private List<Tag> tags;
}

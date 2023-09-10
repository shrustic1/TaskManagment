package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.TagDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TagManagerTest {
    private TagManager tagManager;
    private Tag tag;
    private TagDaoSQLImpl tagDaoSQLMock;
    private List<Tag> tags;
    /**
     * This method will be called before each test method
     */
    @BeforeEach
    public void initializeObjects() {
        tagManager = Mockito.mock(TagManager.class);
        tag = new Tag();
        tag.setName("kupovina");
        tag.setId(50);

        tagDaoSQLMock = Mockito.mock(TagDaoSQLImpl.class);
        tags = new ArrayList<>();
        tags.addAll(Arrays.asList(new Tag("kupovina"), new Tag("hitno"), new Tag("vazno")));
    }
}

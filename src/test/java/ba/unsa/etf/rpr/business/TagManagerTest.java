package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.TagDaoSQLImpl;
import ba.unsa.etf.rpr.exceptions.MyException;
import ba.unsa.etf.rpr.domain.Tag;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TagManagerTest {
    private TagManager tagManager;
    private Tag tag;
    private TagDaoSQLImpl tagDaoSQLMock;
    private List<Tag> tagsList;
    /**
     * This method will be called before each test method
     */
    @BeforeEach
    public void initializeObjects() {
        tagManager = Mockito.mock(TagManager.class);
        tag = new Tag();
        tag.setName("Kupovina");
        tag.setId(50);

        tagDaoSQLMock = Mockito.mock(TagDaoSQLImpl.class);
        tagsList = new ArrayList<>();
        tagsList.addAll(Arrays.asList(new Tag("Kupovina"), new Tag("Hitno"), new Tag("Vazno")));
    }

}

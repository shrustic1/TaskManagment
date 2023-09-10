package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.TagDaoSQLImpl;
import ba.unsa.etf.rpr.exceptions.MyException;
import ba.unsa.etf.rpr.domain.Tag;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        tag.setName("Kupovina");
        tag.setId(50);

        tagDaoSQLMock = Mockito.mock(TagDaoSQLImpl.class);
        tags = new ArrayList<>();
        tags.addAll(Arrays.asList(new Tag("Kupovina"), new Tag("Hitno"), new Tag("Vazno")));
    }
    @Test
    void validateTagName() throws MyException {
        String correctName = "";
        try {
            Mockito.doCallRealMethod().when(tagManager).validateTagName(correctName);
        } catch (MyException e) {
            //Test will fall if method validateCategoryName(name) throws an exception for correct parameter
            e.printStackTrace();
            Assertions.assertTrue(false);
        }

        String incorrectNameShort = "A";
        Mockito.doCallRealMethod().when(tagManager).validateTagName(incorrectNameShort);
        MyException quoteException1 = Assertions.assertThrows(MyException.class, () -> {
            tagManager.validateTagName(incorrectNameShort);}, "Tag name must be between 3 and 45 chars");
        Assertions.assertEquals("Tag name must be between 3 and 45 chars", quoteException1.getMessage());

        String incorrectNameLong = RandomStringUtils.randomAlphabetic(50);
        Mockito.doCallRealMethod().when(tagManager).validateTagName(incorrectNameLong);
        MyException quoteException2 = Assertions.assertThrows(MyException.class, () -> {
            tagManager.validateTagName(incorrectNameLong);}, "Tag name must be between 3 and 45 chars");
        Assertions.assertEquals("Tag name must be between 3 and 45 chars", quoteException2.getMessage());
    }
    /**
     * Adding a new category
     * @throws MyException
     */
    @Test
    void addNewCategory() throws MyException {
        Tag newCategory = new Tag("Novi tag");
        tagManager.add(newCategory);

        Assertions.assertTrue(true);
        Mockito.verify(tagManager).add(newCategory);
    }
}

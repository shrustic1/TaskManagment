package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.TagDaoSQLImpl;
import ba.unsa.etf.rpr.dao.UserDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Tag;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class UserManagerTest {
    private UserManager userManager;
    private User user;
    private UserDaoSQLImpl userDaoSQLMock;
    private List<User> usersList;


    @BeforeEach
    public void initializeObjects() throws MyException {
        userManager = Mockito.mock(UserManager.class);
        user = new User();
        user.setId(1);
        userDaoSQLMock = Mockito.mock(UserDaoSQLImpl.class);
        usersList = new ArrayList<User>();
        usersList.add(user);

    }

    /**
     * tests adding a new user
     * @throws MyException
     */
    @Test
    void addNewUserTest() throws MyException {
        User newUser = new User(56, "Aida","Hrustic", "aidah@gmail.com", "sifra");
        userManager.add(newUser);

        Assertions.assertTrue(true);
        Mockito.verify(userManager).add(newUser);
    }

}

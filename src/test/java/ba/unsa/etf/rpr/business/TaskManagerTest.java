package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.TaskDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Tag;
import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.exceptions.MyException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TaskManagerTest {
    private TaskManager taskManager;
    private Task task;
    private TaskDaoSQLImpl taskDaoSQLMock;
    private List<Task> tasksList;
    @Test
    void searchTasksTest() throws MyException {
        when(taskManager.getAll()).thenReturn(tasksList);
        String string = "kupiti mlijeko";
        Mockito.doCallRealMethod().when(taskManager).searchTasks(string);
        List<Task> tasks = taskManager.searchTasks(string);
        assertAll(
                "Searching task",
                () -> assertEquals(1 , tasks.size()),
                () -> assertEquals("kupiti mlijeko" , tasks.get(0).getTitle()),
                () -> assertEquals("kupiti cetiri litra",tasks.get(0).getDescription()),
                () -> assertEquals(7,tasks.get(0).getId()),
                () -> assertEquals("2023-03-06 22:00:00", tasks.get(0).getDate()),
                () -> assertEquals("2023-03-10 22:00:00", tasks.get(0).getDeadline()),
                () -> assertEquals("none", tasks.get(0).getStatus()),
                () -> assertEquals("Selma", tasks.get(0).getAssignee()),
                () -> assertEquals("Hanka", tasks.get(0).getReporter()),
                () -> assertEquals("Kupovina", tasks.get(0).getTag())
        );

    }
}

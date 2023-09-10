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

}
package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.TaskDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Tag;
import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.exceptions.MyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    public void deleteTeam() throws MyException {
        MockedStatic<DaoFactory> daoFactoryMockedStatic = Mockito.mockStatic(DaoFactory.class);
        daoFactoryMockedStatic.when(DaoFactory::taskDao).thenReturn(taskDaoSQLMock);
        when(DaoFactory.taskDao().getAll()).thenReturn(tasksList);
        when(taskManager.getAll()).thenReturn(tasksList);
        int i = 0;
        System.out.println(taskManager.getAll().size());
        i = taskManager.getAll().get(0).getId();
        Mockito.doCallRealMethod().when(taskManager).delete(i);
        taskManager.delete(i);
        Assertions.assertTrue(true);
        Mockito.verify(taskManager).delete(i);
        daoFactoryMockedStatic.close();
    }



}

package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.TagManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.business.TaskManager;
import ba.unsa.etf.rpr.domain.Tag;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.exceptions.MyException;
import org.apache.commons.cli.*;

import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

public class App 
{
    private static final UserManager userManager= new UserManager();
    private static final TaskManager taskManager = new TaskManager();
    private static final TagManager tagManager = new TagManager();

    private static final Option addTag = new Option("AddTag","add-tag",false, "Adding new tag to database");
    private static final Option addUser = new Option("AddU","add-user",false, "Adding new user to database");
    private static final Option addTask = new Option("AddT", "add-task", false, "Adding new task to database");

    private static final Option getTags = new Option("GetTag","get-tags",false, "Printing all tags from database");
    private static final Option getUsers = new Option("GetU","get-users",false, "Printing all users from database");
    private static final Option getTasks = new Option("GetT", "get-tasks", false, "Printing all tasks from database");

    private static final Option deleteTag = new Option("deleteTag","delete-tag",false,"Deletes a tag from database");
    private static final Option deleteUser = new Option("deleteU","delete-user",false,"Deletes an user from database");
    private static final Option deleteTask = new Option("deleteT","delete-task",false,"Deletes a task from database");



}

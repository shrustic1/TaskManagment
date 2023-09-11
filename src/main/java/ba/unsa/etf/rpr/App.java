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



}

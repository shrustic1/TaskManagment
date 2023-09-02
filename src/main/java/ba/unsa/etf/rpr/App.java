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

    public static void printFormattedOptions(Options options){
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar projekat.jar [option] 'something else if needed' ");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);
        printWriter.close();
    }
    public static Options addOptions(){
        Options options = new Options();
        options.addOption(addTag);
        options.addOption(addTask);
        options.addOption(addUser);
        options.addOption(getTags);
        options.addOption(getTasks);
        options.addOption(getUsers);
        options.addOption(deleteTag);
        options.addOption(deleteTask);
        options.addOption(deleteUser);
        return options;
    }
    public static Tag searchThroughTags(List<Tag> listOfTags, String nameOfTag){
        Tag tag = null;
        tag = listOfTags.stream().filter(m -> m.getName().toLowerCase().equals(nameOfTag.toLowerCase())).findAny().get();
        return tag;
    }
    public static User searchThroughUsers(List<User> listOfUsers, String nameOfUser){
        User user = null;
        user = listOfUsers.stream().filter(m -> m.getName().toLowerCase().equals(nameOfUser.toLowerCase())).findAny().get();
        return user;
    }
    public static Task searchThroughTasks(List<Task> listOfTasks, String nameOfTask){
        Task task = null;
        task = listOfTasks.stream().filter(m -> m.getTitle().toLowerCase().equals(nameOfTask.toLowerCase())).findAny().get();
        return task;
    }
    public static void main( String[] args ) throws ParseException, MyException {
        Options options = addOptions();
        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine cl = commandLineParser.parse(options, args);

        if (cl.hasOption(addTask.getOpt()) || cl.hasOption(addTask.getLongOpt())){
            User assignee = null;
            User reporter = null;
            Tag tag = null;
            try {
                tag = searchThroughTags(tagManager.getAll(), cl.getArgList().get(6));
                assignee = searchThroughUsers(userManager.getAll(), cl.getArgList().get(4));
                reporter = searchThroughUsers(userManager.getAll(), cl.getArgList().get(5));
            } catch(Exception e){
                System.out.println("There is no that tag/user in the list! Try again.");
                System.exit(1);
            }
            try {
                Task task = new Task();
                task.setTitle(cl.getArgList().get(0));
                task.setDescription(cl.getArgList().get(1));
                task.setDate(Date.valueOf(LocalDate.now()));
                SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy;HH:mm:ss");
                task.setDeadline(sf.parse(cl.getArgList().get(2)));
                task.setStatus(cl.getArgList().get(3));
                task.setReporter(reporter);
                task.setAssignee(assignee);
                task.setTag(tag);
                taskManager.add(task);
                System.out.println("Task has been added successfully!");
            } catch(Exception e){
                System.out.println("There is already task with same name in database! Try again.");
                System.exit(1);
            }
        } else if (cl.hasOption(addUser.getOpt()) || cl.hasOption(addUser.getLongOpt())){
            try {
                User user = new User();
                user.setName(cl.getArgList().get(0));
                user.setSurname(cl.getArgList().get(1));
                user.setEmail(cl.getArgList().get(2));
                user.setPassword(cl.getArgList().get(3));
                userManager.add(user);
                System.out.println("User has been added successfully!");
            } catch(Exception e){
                System.out.println("There is already user with same name in database! Try again.");
                System.exit(1);
            }
        } else if (cl.hasOption(addTag.getOpt()) || cl.hasOption(addTag.getLongOpt())){
            try {
                Tag tag = new Tag();
                tag.setName(cl.getArgList().get(0));
                tagManager.add(tag);
                System.out.println("Tag has been added successfully!");
            } catch(Exception e){
                System.out.println("There is already tag with same name in database! Try again.");
                System.exit(1);
            }
        } else if(cl.hasOption(getUsers.getOpt()) || cl.hasOption(getUsers.getLongOpt())){
            userManager.getAll().forEach(s -> System.out.println(s.getName()));
        } else if(cl.hasOption(getTags.getOpt()) || cl.hasOption(getTags.getLongOpt())){
            tagManager.getAll().forEach(c -> System.out.println(c.getName()));
        } else if(cl.hasOption(getTasks.getOpt()) || cl.hasOption(getTasks.getLongOpt())){
            taskManager.getAll().forEach(z -> System.out.println(z.getTitle()));
        } else if(cl.hasOption(deleteTask.getOpt()) || cl.hasOption(deleteTask.getLongOpt())){
            Task task = null;
            try{
                task = searchThroughTasks(taskManager.getAll(), cl.getArgList().get(0));
            }
            catch(Exception e){
                System.out.println("Such task is not in the database!");
                System.exit(1);
            }
            try{
                taskManager.delete(task.getId());
                System.out.println("This task is now removed from the database!");
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("Try again!");
                System.exit(1);
            }
        } else if(cl.hasOption(deleteTag.getOpt()) || cl.hasOption(deleteTag.getLongOpt())){
            Tag tag = null;
            try{
                tag = searchThroughTags(tagManager.getAll(), cl.getArgList().get(0));
            }
            catch(Exception e){
                System.out.println("Such tag is not in the database!");
                System.exit(1);
            }
            try{
                tagManager.delete(tag.getId());
                System.out.println("This tag is now removed from the database!");
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("Try again!");
                System.exit(1);
            }
        } else if(cl.hasOption(deleteUser.getOpt()) || cl.hasOption(deleteUser.getLongOpt())){
            User user = null;
            try{
                user = searchThroughUsers(userManager.getAll(), cl.getArgList().get(0));
            }
            catch(Exception e){
                System.out.println("Such user is not in the database!");
                System.exit(1);
            }
            try{
                userManager.delete(user.getId());
                System.out.println("This user is now removed from the database!");
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("Try again!");
                System.exit(1);
            }
        } else {
            printFormattedOptions(options);
            System.exit(-1);
        }
    }
}

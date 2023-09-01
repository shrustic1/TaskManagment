package ba.unsa.etf.rpr.domain;

import java.util.Date;

public class Task implements Idable{
    private int id;
    private String title;
    private String description;
    private Date date;
    private Date deadline;
    private String status;
    private User reporter;
    private User assignee;
    private Tag tag;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    public User getReporter() {
        return reporter;
    }

    public User getAssignee() {
        return assignee;
    }

    public Tag getTag() {
        return tag;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}

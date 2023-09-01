package ba.unsa.etf.rpr.domain;

import java.util.Date;

public class Task {
    private int id;
    private String title;
    private String description;
    private Date date;
    private Date deadline;
    private String status;
    private int reported_id;
    private int assignee_id;
    private int tag_id;

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

    public int getReported_id() {
        return reported_id;
    }

    public int getAssignee_id() {
        return assignee_id;
    }

    public int getTag_id() {
        return tag_id;
    }
}

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
}

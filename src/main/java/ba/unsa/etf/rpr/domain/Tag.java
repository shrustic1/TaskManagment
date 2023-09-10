package ba.unsa.etf.rpr.domain;

public class Tag implements Idable{
    private int id;
    private String name;
    public Tag(){}
    public Tag(String name){
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

package Library.object;

public class Student {
    int b_id;
    String b_name;
    private int id;
    private String name;
    private String surname;
    private String group;
    public Student(int id, String name, String surname, String group , int b_id , String b_name) {
        this.b_id = b_id;
        this.b_name = b_name;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.group = group;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }

    public String getGroup() {
        return group;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}

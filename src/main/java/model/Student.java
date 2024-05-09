package model;

public class Student {
    private int id;
    private String name;
    private String nameClass;

    public Student() {
    }

    public Student(int id, String name, String nameClass) {
        this.id = id;
        this.name = name;
        this.nameClass = nameClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameClass='" + nameClass + '\'' +
                '}';
    }
}

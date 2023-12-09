package github.sh1rsh1n.entity;

public class Student {
    
    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    private String name;

    private int age;

    private transient double gpa;

    
}

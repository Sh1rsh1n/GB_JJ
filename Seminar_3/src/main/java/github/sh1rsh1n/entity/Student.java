package github.sh1rsh1n.entity;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;

    private int age;

    private transient double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }


    @Override
    public String toString() {
        return "Student: {" +
            " name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            "}";
    }

}

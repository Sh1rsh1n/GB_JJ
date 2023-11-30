package github.sh1rsh1n.task1.pojo;

/**
 * Animal
 */
public abstract class Animal {

    private String name;

    private int age;

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Some voice...");
    }
}
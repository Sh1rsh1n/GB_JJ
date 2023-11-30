package github.sh1rsh1n.task1.pojo;

/**
 * Dog
 */
public class Dog extends Animal{

    String ownerName;

    protected String type;

    public Dog(String name, int age) {
        super(name, age);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getType() {
        return type;
    }
}
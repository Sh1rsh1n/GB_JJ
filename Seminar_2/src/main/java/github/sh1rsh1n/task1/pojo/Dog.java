package github.sh1rsh1n.task1.pojo;

/**
 * Dog
 */
public class Dog extends Animal{

    private String ownerName;

    private String type;

    public Dog(String name, int age) {
        super(name, age);
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
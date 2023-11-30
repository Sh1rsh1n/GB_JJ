package github.sh1rsh1n.task1.pojo;


/**
 * Cat
 */
public class Cat extends Animal {

    private boolean homeless;

    public Cat(){
        this.homeless = true;
    }
    
    public Cat(String name, int age) {
        super(name, age);
    }

    public boolean isHomeless() {
        return this.homeless;
    }

    public void setHomeless(boolean homeless) {
        this.homeless = homeless;
    }

    @Override
    public void makeSound(){
        System.out.println("MEOOOOOOOOOW!");
    }
}

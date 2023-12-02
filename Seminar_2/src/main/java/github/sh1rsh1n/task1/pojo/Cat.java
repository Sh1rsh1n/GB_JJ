package github.sh1rsh1n.task1.pojo;


/**
 * Cat
 */
public class Cat extends Animal {

    public boolean homeless;

    private String color;

    public Cat(){
        homeless = true;
        color = "orange";
    }
    
    public Cat(String name, int age) {
        super(name, age);
    }

    private void makeSound(String str){
        System.out.println(str);
    }
}

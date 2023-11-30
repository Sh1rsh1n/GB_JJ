package github.sh1rsh1n.task1;

import github.sh1rsh1n.task1.pojo.Animal;
import github.sh1rsh1n.task1.pojo.Dog;

/**
 * MainApp
 */
public class MainApp {

    public static void main(String[] args) {
        
        Dog dog1 = new Dog("Шарик", 7);
        dog1.setOwnerName("Вова");
        dog1.setType("Охотничья");
        Dog dog2 = new Dog("Тузик", 3);
        Dog dog3 = new Dog("Той", 4);
        Cat cat1 = new Cat("Матроскин", 6);
        Cat cat2 = new Cat("Рыжий", 2);

        Animal[] animals = new Animal[]{dog1, dog2, dog3, cat1, cat2};


    }
}
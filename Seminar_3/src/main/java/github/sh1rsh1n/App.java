package github.sh1rsh1n;

import github.sh1rsh1n.data_handlers.SimpleDataHandler;
import github.sh1rsh1n.entity.Student;


public class App {
    

    public static void main(String[] args) throws ClassNotFoundException {

        Student st1 = new Student("Egor", 20, 8.7);

        SimpleDataHandler.encodeData(st1, false);

        Object object = SimpleDataHandler.decodeData(Student.class);

        System.out.println(object);
    }

}

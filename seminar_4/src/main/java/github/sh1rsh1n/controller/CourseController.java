package github.sh1rsh1n.controller;

import github.sh1rsh1n.entity.Course;
import github.sh1rsh1n.repository.CourseRepositoryImpl;
import github.sh1rsh1n.repository.Repository;
import github.sh1rsh1n.service.CourseService;
import github.sh1rsh1n.service.Service;

import java.util.List;
import java.util.Scanner;

public class CourseController {

    private final Repository repository;
    private final Service service;

    public CourseController() {
        repository = new CourseRepositoryImpl();
        service = new CourseService(repository);
//        insertData();
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!input.equals("0")) {
            System.out.println(">>>> ДОБРО ПОЖАЛОВАТЬ В РЕДАКТОР КУРСОВ <<<<");
            System.out.println("'ДОБАВИТЬ' ВВЕДИТЕ: 1");
            System.out.println("'ИЗМЕНИТЬ' ВВЕДИТЕ: 2");
            System.out.println("'УДАЛИТЬ' ВВЕДИТЕ: 3");
            System.out.println("'НАЙТИ ПО ИДЕНТИФИКАТОРУ' ВВЕДИТЕ: 4");
            System.out.println("'НАЙТИ ВСЁ' ВВЕДИТЕ: 5");
            System.out.println("'ВЫХОД ИЗ ПРОГРАММЫ' ВВЕДИТЕ: 0");

            input = scanner.nextLine();

            switch (input) {
                case "1" -> {
                    Course course = new Course();

                    System.out.print("ВВЕДИТЕ НАЗВАНИЕ КУРСА: ");
                    String title = scanner.nextLine();
                    System.out.print("ВВЕДИТЕ КОЛИЧЕСТВО ЧАСОВ: ");
                    int duration = Integer.parseInt(scanner.nextLine());

                    course.setTitle(title);
                    course.setDuration(duration);

                    service.save(course);
                }
                default -> System.out.println("ВЫ ВВЕЛИ НЕКОРРЕКТНОЕ ЗНАЧЕНИЕ");
            }
        }

    }

    private void insertData() {
        service.save(new Course("Информатика", 40));
        service.save(new Course("Математика", 50));
        service.save(new Course("Физика", 20));
        service.save(new Course("Геометрия", 30));
    }
}

package github.sh1rsh1n.controller;

import github.sh1rsh1n.entity.Course;
import github.sh1rsh1n.repository.CourseRepositoryImpl;
import github.sh1rsh1n.repository.Repository;
import github.sh1rsh1n.service.CourseService;
import github.sh1rsh1n.service.Service;

import java.util.List;
import java.util.Scanner;

public class CourseController {

    private final Service<Course> service;

    private final Scanner scanner;

    public CourseController() {
        Repository<Course> repository = new CourseRepositoryImpl();
        service = new CourseService(repository);
        scanner = new Scanner(System.in);
    }

    public void start() {

        String input = "";

        while (!input.equals("0")) {
            System.out.println(">>>> ДОБРО ПОЖАЛОВАТЬ В РЕДАКТОР КУРСОВ <<<<");
            System.out.println("'ДОБАВИТЬ' ВВЕДИТЕ: 1");
            System.out.println("'ИЗМЕНИТЬ' ВВЕДИТЕ: 2");
            System.out.println("'УДАЛИТЬ' ВВЕДИТЕ: 3");
            System.out.println("'НАЙТИ ПО ИДЕНТИФИКАТОРУ' ВВЕДИТЕ: 4");
            System.out.println("'НАЙТИ ВСЁ' ВВЕДИТЕ: 5");
            System.out.println("'ВЫХОД ИЗ ПРОГРАММЫ' ВВЕДИТЕ: 0");
            System.out.print(">>> ");

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
                case "2" -> {
                    Course course = findCourseByID();
                    System.out.printf("\nИЗМЕНЕНИЕ ПАРАМЕТРОВ КУРСА: %s, хотите продолжить введите 'Y'(yes)?", course.getTitle());

                    if (scanner.nextLine().equalsIgnoreCase("y")) {
                        System.out.print("ВВЕДИТЕ НАЗВАНИЕ КУРСА: ");
                        String title = scanner.nextLine();
                        System.out.print("ВВЕДИТЕ КОЛИЧЕСТВО ЧАСОВ: ");
                        int duration = Integer.parseInt(scanner.nextLine());
                        course.setTitle(title);
                        course.setDuration(duration);
                        service.save(course);
                    }
                }
                case "3" -> {
                    Course course = findCourseByID();
                    System.out.printf("\nВЫ ХОТИТЕ УДАЛИТЬ КУРС: %s, хотите продолжить введите 'Y'(yes)?", course.getTitle());

                    if (scanner.nextLine().equalsIgnoreCase("y")) {
                        service.remove(course);
                    }
                }
                case "4" -> {
                    Course course = findCourseByID();
                    System.out.println();
                    printCourse(course);
                }
                case "5" -> {
                    List<Course> courses = service.getAll();
                    System.out.println();
                    for (Course course : courses) {
                        printCourse(course);
                    }
                    System.out.println();
                }
                case "0" -> System.out.println("ДО СВИДАНИЯ!!!");
                default -> System.out.println("ВЫ ВВЕЛИ НЕКОРРЕКТНОЕ ЗНАЧЕНИЕ");
            }
        }

    }

    private Course findCourseByID() {
        System.out.print("ВВЕДИТЕ ИДЕНТИФИКАТОР КУРСА: ");
        int id = Integer.parseInt(scanner.nextLine());
        return service.getElementById(id);
    }

    private void printCourse(Course course) {
        System.out.printf("ID: %d КУРС: %s КОЛИЧЕСТВО ЧАСОВ: %d\n\n", course.getId(), course.getTitle(), course.getDuration());
    }
}

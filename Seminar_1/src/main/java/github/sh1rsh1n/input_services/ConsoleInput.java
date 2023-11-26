package java.github.sh1rsh1n.seminar_1.task1.user_service;

import java.util.Scanner;

/**
 * Пользовательский ввод из консоли
 */
public class ConsoleInput implements Input {

    @Override
    public String getInput() {
        System.out.println("Введите несколько чисел через пробел: ");
        try (Scanner scan = new Scanner(System.in)) {
            return scan.nextLine();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        throw new RuntimeException();
    }

}

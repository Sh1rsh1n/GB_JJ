package java.github.sh1rsh1n.seminar_1.task1;

import java.github.sh1rsh1n.seminar_1.task1.handlers.NumberHandler;
import java.github.sh1rsh1n.seminar_1.task1.handlers.GettingAverageNumber;
import java.github.sh1rsh1n.seminar_1.task1.user_service.ConsoleInput;
import java.github.sh1rsh1n.seminar_1.task1.user_service.Input;

public class MainApp {
    
     /**
      * @param input источник данных(реализующий интерфейс Input)
      * @param handler обработчик данных(реализующий интерфейс NumberHandler), переданных через параметр input
      * @return int
      */
    static int getResult(Input input, NumberHandler<? extends Number> handler) {
        return handler.operation(input.getInput()).intValue();
    }

    public static void main(String[] args) {

        int result = getResult(new ConsoleInput(), new GettingAverageNumber());
        System.out.printf("Среднее значение: %d", result);
    }
}

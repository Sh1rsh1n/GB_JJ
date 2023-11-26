package github.sh1rsh1n;

import github.sh1rsh1n.input_services.ConsoleInput;
import github.sh1rsh1n.input_services.Input;
import github.sh1rsh1n.number_handlers.GettingAverageNumber;
import github.sh1rsh1n.number_handlers.NumberHandler;

public class MainApp {
    
     /**
      * @param input источник данных(реализующий интерфейс Input)
      * @param handler обработчик данных(реализующий интерфейс NumberHandler), переданных через параметр input
      * @return long
      */
    static long getResult(Input input, NumberHandler<? extends Number> handler) {
        return handler.operation(input.getInput()).longValue();
    }

    public static void main(String[] args) {

        long result = getResult(new ConsoleInput(), new GettingAverageNumber());
        System.out.printf("Среднее значение: %d\n", result);
    }
}

package java.github.sh1rsh1n.seminar_1.task1.handlers;


/**
 * Интерфейс обработчик чисел
 */
public interface NumberHandler<T extends Number>{
    T operation(String input);
}

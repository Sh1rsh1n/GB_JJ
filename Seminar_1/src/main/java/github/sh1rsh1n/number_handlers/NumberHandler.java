package github.sh1rsh1n.number_handlers;


/**
 * Интерфейс обработчик чисел
 */
public interface NumberHandler<T extends Number>{
    T operation(String input);
}

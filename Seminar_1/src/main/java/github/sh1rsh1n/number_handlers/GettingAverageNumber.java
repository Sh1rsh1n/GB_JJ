package github.sh1rsh1n.number_handlers;

import java.util.Arrays;

/**
 * Вычисление среднего значения
 */
public class GettingAverageNumber implements NumberHandler<Integer>{

    @Override
    public Integer operation(String input) {
        // преобразуем строку в массив строк
        Double avgDouble = Arrays.stream(input.split(" "))  // получаем поток элементов типа String
        .filter(    // выполняем фильтрацию, убераем из потока любые символы кроме чисел
            item -> {
                if (item.isEmpty()) // если символ является пустой строкой
                    return false;
                for (int index = 0; index < item.length(); index++) {
                    if (!Character.isDigit(item.charAt(index))) {   //если символ не число
                        return false;
                    }
                }
                return true;
            }
        )
        .mapToInt(Integer::parseInt)    // преобразуем поток строк в поток чисел
        .filter(item -> item % 2 == 0)  // отфильтруем четные числа
        .average().getAsDouble();   // находим среднее значение, выводим результат
        return avgDouble.intValue();
    }
}

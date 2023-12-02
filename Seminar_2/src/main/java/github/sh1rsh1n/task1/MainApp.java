package github.sh1rsh1n.task1;

import github.sh1rsh1n.task1.pojo.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;


/**
 * MainApp
 */
public class MainApp {

    /**
     * Вспомогательный метод, для перевода
     * целочисленное значение модификатора доступа в строковое значение
     * @param value int
     * @return String
     */
    static String parseModifiers(int value) {
        switch (value) {
            case 0 -> {
                return "package-private";
            }
            case 1 -> {
                return "public";
            }
            case 2 -> {
                return "private";
            }
            case 3 -> {
                return "void";
            }
            case 4 -> {
                return "protected";
            }
            default -> throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        
        Dog dog = new Dog("Шарик", 7);
        Cat cat = new Cat("Рыжий", 2);

        Animal[] animals = new Animal[]{dog, cat};

        Arrays.stream(animals).forEach(animal -> { // получаем поток объектов Animal

            System.out.printf("Class: %s\n", animal.getClass().getSimpleName()); // выводим название класса

            Arrays.stream(animal.getClass().getDeclaredFields()) // получаем поток полей
                    .forEach(field -> { // проходим по всем полям и выводим результат
                System.out.printf("\tField: %s %s %s \n", parseModifiers(field.getModifiers()), field.getType().getSimpleName(), field.getName());
            });

            Arrays.stream(animal.getClass().getDeclaredMethods()) // получаем поток методов
                    .forEach(method -> { // проходим по всем методам
                        //method.setAccessible(true); // получаем доступ ко всем методам
                        StringBuilder sb = new StringBuilder();
                        Arrays.stream(method.getParameters()).forEach(param -> {
                            sb.append(param.getType().getSimpleName());
                            sb.append(" ");
                            sb.append(param.getName());
                        });

                System.out.printf("\tMethod: %s %s %s(%s) {\n\t}\n", parseModifiers(method.getModifiers()), method.getReturnType().getSimpleName(), method.getName(), sb.toString());
            });

            Arrays.stream(animal.getClass().getDeclaredMethods()) // получаем поток методов
                    .filter(method -> method.getName().equals("makeSound")) // отфильтруем методы по названию
                    .forEach(method -> { // проходим по всем методам
                        method.setAccessible(true); // получаем доступ ко всем методам
                        try {
                            method.invoke(animal, "MEOOOOOOW!"); // вызываем метод makeSound() у классов, в которых он есть
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    });
        });
    }
}
package github.sh1rsh1n.data_handlers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Задание №1
 * Класс, обработчик данных
 * метод encodeData(Object, boolean) - принимает данные и записывает их в файл
 * метод decodeData(Class) - в параметрах ожидает класс, в который нужно преобразовать данные из файла
 */
public class SimpleDataHandler {
    
    private static final Path path = Paths.get("Seminar_3/src/main/java/github/sh1rsh1n/Students.bin");

    /**
     * кодирование данных в файл
     * 
     * @param obj    - любой объект
     * @param append - возможность дополнять данные в файл
     */
    public static void encodeData(Object obj, boolean append) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(path.toString(), append);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(obj);

            System.out.printf("Объект %s сериализован.\n", obj.getClass().getSimpleName());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * декодирование данных из файла
     * @param clazz - класс, объект которого мы ожидаем получить из данных в файле.
     * @return Class
     */
    public static Object decodeData(Class<?> clazz) {

        try (FileInputStream fileInputStream = new FileInputStream(path.toString());
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            System.out.printf("Объект %s десериализован.\n", clazz.getSimpleName());
            
            return clazz.cast(objectInputStream.readObject());

        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }
        throw new RuntimeException();
    }
}

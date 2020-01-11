import java.io.*;
import java.util.*;

public class FileUtility {

    /*
     * Структура файла ввода: в первой строке одно целое число - N
     * далее следует N целых чисел через пробел
     * Метод должен отсортировать элементы с четным значением,
     * а нечетные оставить на своих местах и вывести результат через пробел в файл вывода
     * Пример:
     * in:
     * 5
     * 5 4 2 1 3    // 2 4
     * out:
     * 5 2 4 1 3
     */
    public void sortEvenElements(File in, File out) {
        Scanner scanner = null;
        PrintWriter writer = null;
        try {
            scanner = new Scanner(in);
            int n = scanner.nextInt();
            List<Integer> fullList = new ArrayList<>();
            LinkedList<Integer> evenList = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int value = scanner.nextInt();
                fullList.add(value);
                if (value % 2 == 0) {
                    evenList.add(value);
                }
            }
            Collections.sort(evenList);
            writer = new PrintWriter(out);
            for (Integer value : fullList) {
                writer.print((value % 2 == 0 ? evenList.pollFirst() : value) + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            close(scanner);
            close(writer);
        }
    }

    /*
     * Генератор паролей, пароль должен отвечать требованиям:
     * длина не менее 6 и не более 12, включает минимум по одному символу
     * из наборов: a-z, A-Z, 0-9, {*,!,%}
     * все пароли должны быть разными
     * На вход метод получает файл с логинами пользователей
     * Метод должен записать в файл вывода записи с логинами и паролями
     * для каждого пользователя
     */

    public void passwordGen(File in, File out) {
        Scanner scanner = null;
        PrintWriter writer = null;
        try {
            scanner = new Scanner(in);
            writer = new PrintWriter(out);
            PasswordBuilder passwordBuilder = new PasswordBuilder()
                    .setDigitsRule(1)
                    .setUpperCaseCharsRule(1)
                    .setLowerCaseCharsRule(1)
                    .setSpecialCharsRule(1);
            while (scanner.hasNextLine()) {
                String login = scanner.nextLine();
                writer.println(login + " " + passwordBuilder.generate(getRandomNumInRange(6, 12)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            close(scanner);
            close(writer);
        }
    }

    private static int getRandomNumInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return r.nextInt((max - min) + 1) + min;
    }

    private static Random r = new Random();

    /*
     *  Метод должен дописать в переданный файл все
     * записи из списка по одной записи в строке
     * */
    public void appender(File file, List<String> records) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))) {
            records.forEach(writer::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
     * Метод возвращает список из N последних строк файла
     * строки можно дополнять пробелами до длины 80
     * тогда количество символов в файле будет предсказуемо
     * 10 строк это ровно 800 символов
     * Изучите класс RandomAccessFile для эффективного решения данной
     * задачи
     * Альтернативное решение: использование очереди или стека
     * */
    public List<String> getNString(String pathToFile, int n) {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile(pathToFile, "r");
            file.seek(file.length() - 81 * n);
            List<String> list = new ArrayList<>();
            String line;
            while ((line = file.readLine()) != null) {
                list.add(line);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(file);
        }
        return Collections.emptyList();
    }

    private void close(Closeable value) {
        if (value != null) {
            try {
                value.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

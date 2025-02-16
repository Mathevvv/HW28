import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("============= ДЗ 2 =============");
        System.out.println("Введите путь к файлу или папке: ");
        //String path = new Scanner(System.in).nextLine();
        //printSize(path);

        System.out.println("============= ДЗ 3 =============");
        setSale();
    }

    private static void printSize(String path) throws IOException {
        //todo Дописать код расчета размера и корректного отображения
        File file1 = new File(path);
        long x = file1.length();
        System.out.println("Размер вашего файла в байтах - " + x);
        System.out.println("Размер вашего файла в килобайтах - " + rounder((double) x/1024));
        System.out.println("Размер вашего файла в мегабайтах - " + rounder((double) x/(1024*1024)));
        System.out.println("Размер вашего файла в гигабайтах - " + rounder((double) x/(1024*1024*1024)));
        System.out.println("Размер вашего файла в терабайтах - " + rounder((double) x/(1024.0*1024*1024*1024)));

    }

    private static double rounder(double size){
        return Math.round(size * 100.0) / 100.0;
    }

    private static void setSale() throws IOException {
        //todo Тут написать код для ДЗ #3
        List<String> stringList1 = Files.readAllLines(Path.of("HW28/data/car_price.txt"));
        List<String> stringList2 = new ArrayList<>();
        for (String s : stringList1) {
            stringList2.add(replacerOfPrice(s));
        }
        Files.write(Path.of("HW28/data/car_price2.txt"), stringList2);
    }

    public static String getSecondWord(String input) {
        if (input == null || input.isEmpty()) {
            return null; // Или выбросить исключение IllegalArgumentException
        }

        String[] words = input.split("\\s+"); // Разделяем строку на слова по пробелам

        if (words.length < 2) {
            return null; // Или выбросить исключение IllegalArgumentException
        }

        return words[1]; // Возвращаем второе слово (индекс 1)
    }

    public static String getThirdWord(String input) {
        if (input == null || input.isEmpty()) {
            return null; // Или выбросить исключение IllegalArgumentException
        }

        String[] words = input.split("\\s+"); // Разделяем строку на слова по пробелам

        if (words.length < 3) {
            return null; // Или выбросить исключение IllegalArgumentException
        }

        return words[2]; // Возвращаем второе слово (индекс 2)
    }

    public static String replacerOfPrice(String not) {
        String price1 = getThirdWord(not);
        if (Integer.parseInt(getSecondWord(not))<=2020)
        return not.replaceAll(price1, String.valueOf((parseDouble(price1))*0.95));
        else return not.replaceAll(price1, String.valueOf((parseDouble(price1))*0.98));
    }
}

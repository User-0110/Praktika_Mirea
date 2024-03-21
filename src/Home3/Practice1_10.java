package Home3;

import java.util.Scanner;
import java.io.*;

public class Practice1_10 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Куда записывать файлы? Укажите путь: ");
        File result = new File(scanner.nextLine());
        FileOutputStream outputStream = new FileOutputStream(result);
        System.out.println("Сколько файлов хотите склеить?");
        int number = Integer.parseInt(scanner.nextLine());
        FileInputStream inputStream;
        for (int i = 0; i < number; i++) {
            System.out.println("Введите файл: ");
            File file = new File(scanner.nextLine());
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            outputStream.write(bytes);
            inputStream.close();
        }
        scanner.close();
        outputStream.close();
    }
}
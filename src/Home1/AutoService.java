package Home1;

/*
Вариант 1. Для работы с сущностью АВТОМОБИЛЬ (Car) разработать класс
АВТОСЕРВИС, в котором метод modify будет изменять название (марку)
автомобиля по следующему алгоритму:
         Все символы «a» должны быть заменены на «o»
         Все символы «i» должны быть заменены на «e»
         Все символы должны быть прописными
Начальные значения полей для сущности АВТОМОБИЛЬ вводит
пользователь с клавиатуры после старта программы. В результате работы
программы необходимо вывести на экран все значения полей (в том числе
        измененное) через запятую.
*/

import java.util.Scanner;

public class AutoService {

    public static void getInfo() {
        System.out.println("Анатолий Горшков Рибо-04-22 6 вариант\n\n");
    }

    public static String modify(String name) {
        return name.toUpperCase().replaceAll("A", "O")
                .replaceAll("I", "E");
    }

    public static void main(String[] args) {
        getInfo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите марку автомобиля: ");
        Car car = new Car(scanner.nextLine()); // создали авто
        System.out.println(modify(car.getName()));
    }
}
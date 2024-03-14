package Home2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class CarApplication {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ArrayList<Car> CARS = new ArrayList<>() {{
        add(new Car("BMW", 2015, "x001xx"));
        add(new Car("Lada Vesta", 2020, "x002xx"));
        add(new Car("Kia Rio", 2012, "x003xx"));
    }};
    
    public static void addCar() {
        System.out.println("Введите марку автомобиля - ");
        String name = SCANNER.nextLine();
        int year;
        while (true) {
            System.out.println("Введите год выпуска автомобиля - ");
            try {
                year = Integer.parseInt(SCANNER.nextLine());
                if (year >= 1769){
                    break;
                } else {
                    System.out.println("Машины тогда не существовали...");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Вы ввели не число...");
            }
        }
        System.out.println("Введите регистрационный номер автомобиля - ");
        String number = SCANNER.nextLine();
        CARS.add(new Car(name, year, number));
        showCars();
    }

    public static void deleteCatByNumber(String deleteNumber) {
        Iterator<Car> carIterator = CARS.iterator();
        while (carIterator.hasNext()) {
            String number = carIterator.next().getNumber();
            if (number.equalsIgnoreCase(deleteNumber)) {
                carIterator.remove();
            }
        }
        showCars();
    }

    public static void deleteAllCars() {
        CARS.clear();
    }

    public static void showCars() {
        for (Car car : CARS) {
            System.out.println(car.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println("Горшков Анатолий Рибо-04-22 вариант 6\n");
        System.out.println("Добавление авто...\n");
        addCar();
        System.out.println("Введите номер и удалите авто по номеру\n");
        deleteCatByNumber(SCANNER.nextLine());
        System.out.println("Удаление всех авто...");
        deleteAllCars();
    }
}
package Home4;
import java.util.Scanner;
import java.io.*;

public class Car implements Externalizable {
    private String name;
    private int year;
    private String number;
    private String country;
    private String city;

    public Car() {

    }

    public Car(String name, int year, String number, String country, String city) {
        this.name = name;
        this.year = year;
        this.number = number;
        this.country = country;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(this.getYear());
        out.writeObject(this.getNumber());
        out.writeObject(this.getCountry());
        out.writeObject(this.getCity());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String) in.readObject();
        this.year = (Integer) in.readObject();
        this.number = (String) in.readObject();
        this.country = (String) in.readObject();
        this.city = (String) in.readObject();
    }

    @Override
    public String toString() {
        return name + ", " + year + ", " + number + ", " + country + ", " + city;
    }
}

class SaveRunnable implements Runnable {
    private Car car;
    private String path;

    public SaveRunnable(Car car, String path) {
        this.car = car;
        this.path = path;
    }

    @Override
    public void run() {
        if (this.path != null && this.car != null) {
            try {
                ObjectOutput output = new ObjectOutputStream(new FileOutputStream(path));
                this.car.writeExternal(output);
            } catch (IOException e) {
                System.out.println("Упс, что-то не так)");
            } finally {
                System.out.println("Файл сохранён по пути - " + this.path);
            }
        }
    }
}

class Practice1_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите марку - ");
        String name = scanner.nextLine();
        System.out.println("Введите год выпуска - ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите номер автомобиля - ");
        String number = scanner.nextLine();
        System.out.println("Введите страну выпуска - ");
        String country = scanner.nextLine();
        System.out.println("Введите город выпуска - ");
        String city = scanner.nextLine();

        Car car = new Car(name, year, number, country, city);

        System.out.println("Куда сохранить объект? ");
        String file = scanner.nextLine();

        Thread save = new Thread(new SaveRunnable(car, file));
        save.start();
    }
}
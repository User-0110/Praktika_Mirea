package Home2;

public class Car {
    private String name;
    private int year;
    private String number;

    public Car(String name, int year, String number) {
        this.name = name;
        this.year = year;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name + ", " + year + ", " + number;
    }
}
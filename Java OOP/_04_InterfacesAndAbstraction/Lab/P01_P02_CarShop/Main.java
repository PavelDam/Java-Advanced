package _04_InterfacesAndAbstraction.Lab.P01_P02_CarShop;

public class Main {
    public static void main(String[] args) {
        CarImpl seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
        CarImpl audi = new Audi("A4", "Gray", 110, "Germany", 3, 99.9);

        printCarInfo(seat);
        printCarInfo(audi);
    }

    private static void printCarInfo(Car car) {
        System.out.println(String.format(
                "%s is %s color and have %s horse power",
                car.getModel(),
                car.getColor(),
                car.getHorsePower()));
        System.out.println(car.toString());
    }

}

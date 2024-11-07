package _04_InterfacesAndAbstraction.Lab.P01_P02_CarShop;

public class Seat extends CarImpl implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsepower, String countryProduced, Double price) {
        super(model, color, horsepower, countryProduced);
        this.price = price;
    }


    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(super.toString()).append(System.lineSeparator())
                .append(String.format("%s sells for %f", super.getModel(), price));

        return builder.toString();
    }
}

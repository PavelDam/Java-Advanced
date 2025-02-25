package _04_InterfacesAndAbstraction.Lab.P01_P02_CarShop;

public class Audi extends CarImpl implements Rentable {

    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsepower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsepower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(super.toString()).append(System.lineSeparator())
                .append(String.format("Minimum rental period of %d days. Price per day %f", minRentDay, pricePerDay));

        return builder.toString();
    }
}

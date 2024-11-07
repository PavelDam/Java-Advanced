package _04_InterfacesAndAbstraction.Lab.P01_P02_CarShop;

public  class CarImpl implements  Car{
    private String model;
    private String color;
    private Integer horsepower;
    private String countryProduced;

    public CarImpl(String model, String color, Integer horsepower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsepower;
    }

    @Override
    public String countryProduced() {
        return countryProduced;
    }

    public String getCountryProduced() {
        return countryProduced;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", model, countryProduced, Car.TIRES);
    }
}

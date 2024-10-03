package _01_WorkingWithAbstraction.Lab.P04_HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int days;
    private int season;
    private double discount;

    public PriceCalculator(double pricePerDay, int days, Season season, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season.getMultiplier();
        this.discount = discountType.getDiscount();
    }
    public double calculatePrice() {
        return pricePerDay * days * season * discount;
    }
}

package _06_SOLID.Exercise.Calculator;

import _06_SOLID.Exercise.Product;

import java.util.List;

public class QuantityCalculator implements Calculator {

    @Override
    public double sum(List<Product> products) {
        return  products.stream().mapToDouble(Product::getKilograms).sum();
    }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}

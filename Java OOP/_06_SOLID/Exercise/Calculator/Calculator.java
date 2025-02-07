package _06_SOLID.Exercise.Calculator;

import _06_SOLID.Exercise.Product;

import java.util.List;

public interface Calculator {
    double sum(List<Product> products);
    double average(List<Product> products);
}

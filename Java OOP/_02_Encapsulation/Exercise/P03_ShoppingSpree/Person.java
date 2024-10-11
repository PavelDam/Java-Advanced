package _02_Encapsulation.Exercise.P03_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> productList;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.productList = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw  new IllegalStateException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw  new IllegalStateException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {
        if (money < product.getCost()) {
            throw new IllegalStateException(String.format("%s can't afford %s", name, product.getName()));
        }
        money -= product.getCost();
        System.out.printf("%s bought %s%n", name, product.getName());
        productList.add(product);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" - ");
        if (productList.isEmpty()) {
            builder.append("Nothing bought");
        } else {
            builder.append(productList.stream().map(Product::getName).collect(Collectors.joining(", ")));
        }
        return builder.toString();
    }
}

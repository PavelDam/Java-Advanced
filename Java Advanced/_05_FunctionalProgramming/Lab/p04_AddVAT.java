package _05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class p04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] pricesArr = Arrays.stream(scanner.nextLine().split(", ")).mapToDouble(Double::parseDouble).toArray();

        UnaryOperator<Double> addVat = price -> price * 1.2;

        System.out.println("Prices with VAT:");

        System.out.print(Arrays.stream(pricesArr).map(addVat::apply).mapToObj(d->String.format("%.2f",d)).collect(Collectors.joining(System.lineSeparator())));
    }
}


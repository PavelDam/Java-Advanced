package _04_InterfacesAndAbstraction.Exercise.P05_Telephony;

import _04_InterfacesAndAbstraction.Lab.P06_Ferrari.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Smartphone implements Browsable, Callable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder builder = new StringBuilder();
        urls.forEach(url ->
                builder.append(url.chars().anyMatch(Character::isDigit)
                                ? "Invalid URL!"
                                : "Browsing: " + url)
                        .append(System.lineSeparator())
        );
        return builder.toString();
    }

    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();
        numbers.forEach(num -> builder.append("Calling... ").append(num).append(System.lineSeparator()));
        return builder.toString();
    }
}

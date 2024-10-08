package _01_WorkingWithAbstraction.Exercise.P04_TrafficLights;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] signals = scanner.nextLine().split("\\s+");
        List<TrafficLight> trafficLights = Arrays.stream(signals)
                .map(Color::valueOf)
                .map(TrafficLight::new)
                .collect(Collectors.toList());

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.changeColor();
                System.out.print(trafficLight.getColor()+" ");
            }
            System.out.println();
        }
    }
}

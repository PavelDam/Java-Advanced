package _07_ReflectionAndAnnotation.Exercise.P01_harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
		Class<RichSoilLand> clazz = RichSoilLand.class;
		Field[] fields = clazz.getDeclaredFields();

		Scanner scanner = new Scanner(System.in);
		String modifier = scanner.nextLine();

		while (!"HARVEST".equals(modifier)) {

			printFields(fields, modifier);

			modifier = scanner.nextLine();
		}
    }

	private static void printFields(Field[] fields, String modifier) {

		Consumer<Field> format = (field -> System.out.printf("%s %s %s%n",Modifier.toString(field.getModifiers()),field.getType().getSimpleName(), field.getName()));

		switch (modifier) {
				case "private":
					Arrays.stream(fields).filter(field -> Modifier.isPrivate(field.getModifiers()))
							.forEach(format);
					break;
				case "public":
					Arrays.stream(fields).filter(field -> Modifier.isPublic(field.getModifiers()))
							.forEach(format);
					break;
				case "protected":
					Arrays.stream(fields).filter(field -> Modifier.isProtected(field.getModifiers()))
							.forEach(format);
					break;
				case "all":
					Arrays.stream(fields).forEach(format);
					break;
			}
	}
}

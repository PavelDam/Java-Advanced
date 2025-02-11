package _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}

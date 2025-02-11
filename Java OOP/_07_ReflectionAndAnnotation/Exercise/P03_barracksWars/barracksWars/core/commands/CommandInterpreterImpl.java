package _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.core.commands;

import _04_InterfacesAndAbstraction.Lab.P01_P02_CarShop.Sellable;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.CommandInterpreter;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.Executable;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.Repository;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.Set;

public class CommandInterpreterImpl implements CommandInterpreter {

    private final static String COMMAND_PACKAGE = "_07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String commandType = parseCommand(commandName);

        try {
            Class commandClass = Class.forName(COMMAND_PACKAGE + commandType);
            Constructor<Command> constructor = commandClass.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
            Executable executable = constructor.newInstance(data, repository, unitFactory);
            return executable;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 RuntimeException | InvocationTargetException e) {
            throw new IllegalArgumentException("Invalid command!");
        }
    }

    private static String parseCommand(String commandName) {
        return Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1) + "Command";
    }
}

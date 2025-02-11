package _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars;

import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.core.commands.CommandInterpreterImpl;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.Repository;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.Runnable;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.UnitFactory;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.core.Engine;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.core.factories.UnitFactoryImpl;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreterImpl commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);
        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}

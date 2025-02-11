package _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.core.factories;

import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.Unit;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "_07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        try {
            Class unit = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<Unit> unitConstructor = unit.getDeclaredConstructor();
            return unitConstructor.newInstance();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new IllegalArgumentException("Invalid unit!");
        }
    }
}

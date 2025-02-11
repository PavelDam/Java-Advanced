package _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.core.commands;

import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.Executable;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.Repository;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    public Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    public String[] getData() {
        return data;
    }

    public Repository getRepository() {
        return repository;
    }

    public UnitFactory getUnitFactory() {
        return unitFactory;
    }
}

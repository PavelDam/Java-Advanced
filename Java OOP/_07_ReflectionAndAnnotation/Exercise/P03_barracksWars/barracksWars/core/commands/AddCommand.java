package _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.core.commands;

import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.Repository;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.Unit;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.UnitFactory;

public class AddCommand extends Command{

    public AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;

    }
}

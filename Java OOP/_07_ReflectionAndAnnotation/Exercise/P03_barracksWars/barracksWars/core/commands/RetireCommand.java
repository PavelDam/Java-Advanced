package _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.core.commands;

import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.Repository;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.UnitFactory;

public class RetireCommand extends Command {
    protected RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        try {
            String unitType = getData()[1];
            getRepository().removeUnit(unitType);
            return String.format("%s retired!", unitType);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

    }
}

package _04_InterfacesAndAbstraction.Exercise.P06_MilitaryElite;

import java.util.Collections;

public class EngineerImpl implements Repair {
    String partName;
    int hoursWorked;

    public EngineerImpl(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }


    @Override
    public void addRepair() {

    }
}

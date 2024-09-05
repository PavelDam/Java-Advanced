package _Exams.Exam_19February2022.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
               this.data.remove(parrot);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        Parrot toReturn = null;
        for (Parrot r : this.data) {
            if (r.getName().equals(name)) {
                r.setAvailable(false);
                toReturn = r;
            }
        }
        return toReturn;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> list = new ArrayList<>();
        this.data.forEach(i -> {
            if (i.getSpecies().equals(species)) {
                i.setAvailable(false);
                list.add(i);
            }
        });
        return list;
    }

    public int count() {
        return this.data.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Parrots available at %s:%n",name));
        for (Parrot parrot : data) {
            if (parrot.isAvailable()){
                builder.append(parrot).append(System.lineSeparator());
            }
        }
        return builder.toString().trim();
    }
}

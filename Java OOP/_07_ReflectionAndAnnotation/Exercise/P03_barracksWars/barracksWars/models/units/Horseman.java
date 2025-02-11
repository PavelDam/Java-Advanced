package _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.models.units;



public class Horseman extends AbstractUnit {
    private static final int HORSEMAN_HEALTH = 20;
    private static final int HORSEMAN_DAMAGE = 20;

    public Horseman() {
        super(HORSEMAN_HEALTH, HORSEMAN_DAMAGE);
    }
}

import java.io.Serializable;

public class WildTurkey implements  Turkey, Serializable {
    private String name;
    transient private int turkeyHandle = 10;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I can fly a short distanche");
    }

}

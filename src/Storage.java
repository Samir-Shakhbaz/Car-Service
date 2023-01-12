import java.util.List;

public class Storage {

    private List<Tire> summerTires;
    private List<Tire> winterTires;

    public Storage(List<Tire> summerTires, List<Tire> winterTires) {
        this.summerTires = summerTires;
        this.winterTires = winterTires;
    }

    public Storage() {

    }

    public List<Tire> getSummerTires() {
        return summerTires;
    }

    public void setSummerTires(List<Tire> summerTires) {
        this.summerTires = summerTires;
    }

    public List<Tire> getWinterTires() {
        return winterTires;
    }

    public void setWinterTires(List<Tire> winterTires) {
        this.winterTires = winterTires;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "summerTires=" + summerTires +
                ", winterTires=" + winterTires +
                '}';
    }
}

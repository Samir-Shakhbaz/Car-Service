import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {

    private List<Tire> summerTires;
    private List<Tire> winterTires;

    private Map<Car, List<Tire>> thisCarTiresSummer;
    private Map<Car, List<Tire>> thisCarTiresWinter;
    private Car car;
    private Customer customer;

    public Storage(List<Tire> summerTires, List<Tire> winterTires) {
        this.summerTires = summerTires;
        this.winterTires = winterTires;
        this.thisCarTiresSummer = new HashMap<>();
        this.thisCarTiresWinter = new HashMap<>();

    }

    public Storage() {
        this.summerTires = summerTires();
        this.winterTires = winterTires();
        this.thisCarTiresSummer = new HashMap<>();
        this.thisCarTiresWinter = new HashMap<>();

    }

    public static List<Tire> summerTires() {

        List<Tire> summerTires = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            summerTires.add(new Tire(i, "GoodYear"));
        }
        return summerTires;
    }

    public static List<Tire> winterTires() {
        List<Tire> winterTires = new ArrayList<>();
        for (int x = 100; x < 200; x++) {
            winterTires.add(new Tire(x, "GoodYear"));
        }
        return winterTires;
    }


    public void printTires() {
        System.out.print("[");
        for (int i = 0; i < getSummerTires().size(); i++) {
            Tire tire = getSummerTires().get(i);
            System.out.print(tire.getTireId() + ",");
        }
        System.out.println("]");

        System.out.print("[");
        for (int i = 0; i < getWinterTires().size(); i++) {
            Tire tire = getWinterTires().get(i);
            System.out.print(tire.getTireId() + ",");
        }
        System.out.println("]");
    }


//    public void takeOfTires() {
//
//        Tire tire = car.getTireList().get(0);
//        List<Tire> summerTires = new ArrayList<>();
//        summerTires.remove(tire);
//        getThisCarTires().put(car, tireList);
//    }
//            System.out.println(tire);
//
//
//    thisCarTires .
//
//
//}


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

    public Map<Car, List<Tire>> getThisCarTiresSummer() {
        return thisCarTiresSummer;
    }

    public void setThisCarTiresSummer(Map<Car, List<Tire>> thisCarTiresSummer) {
        this.thisCarTiresSummer = thisCarTiresSummer;
    }

    public Map<Car, List<Tire>> getThisCarTiresWinter() {
        return thisCarTiresWinter;
    }

    public void setThisCarTiresWinter(Map<Car, List<Tire>> thisCarTiresWinter) {
        this.thisCarTiresWinter = thisCarTiresWinter;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "summerTires=" + summerTires +
                ", winterTires=" + winterTires +
                ", thisCarTiresSummer=" + thisCarTiresSummer +
                ", thisCarTiresWinter=" + thisCarTiresWinter +
                '}';
    }
}

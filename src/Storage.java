import java.util.*;
import java.util.stream.Collectors;

public class Storage {

    private List<Tire> summerTires;
    private List<Tire> winterTires;

    private Map<Car, List <Tire>> thisCarTires;
    private Car car;
    private Customer customer;

    public Storage(List<Tire> summerTires, List<Tire> winterTires) {
        this.summerTires = summerTires;

        this.winterTires = winterTires;
        this.thisCarTires = new HashMap<>();

    }



    public void takeOfTires(){

        Tire tire = car.getTireList().get(0);
        List<Tire> summerTires = new ArrayList<>();
        summerTires.remove(tire);
        getThisCarTires().put(car, tireList);
    }
            System.out.println(tire);


    thisCarTires.


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

    public Map<Car, List<Tire>> getThisCarTires() {
        return thisCarTires;
    }

    public void setThisCarTires(Map<Car, List<Tire>> thisCarTires) {
        this.thisCarTires = thisCarTires;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "summerTires=" + summerTires +
                ", winterTires=" + winterTires +
                "thisCarTires=" + thisCarTires +
                '}';
    }
}

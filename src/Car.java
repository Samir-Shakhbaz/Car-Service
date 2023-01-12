import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {

    private int id;
    private String make;
    private String model;
    private int year;

    private List<Tire> tireList;
//    private Tire [] tires = new Tire[4];
//    public Car(Tire[] tires) {
//        this.tires = tires;
//    }


    public int getId() {
        return id;
    }

    public Car(int id) {
        this.id = id;
        this.tireList = new ArrayList<>();
    }

    public List<Tire> getTireList() {
        return tireList;
    }

    //    public Tire[] getTires() {
//        return tires;
//    }
//
//    public void setTires(Tire[] tires) {
//        this.tires = tires;
//    }

    public Car(){}

    public Car(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make){
        this.make = make;
    }

    public String getModel(){return model;}

    public void setModel(String model){this.model = model;}

    public int getYear(){return year;}

    public void setYear(int year){this.year = year;}

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", tireList=" + tireList +
                '}';
    }
}

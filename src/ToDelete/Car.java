import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Car {

    private int id;
    private String make;
    private String model;
    private int year;

    private Storage storage;

    public Car(int id, String make, String model, int year, Storage storage, List<Tire> tireList) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.storage = storage;
        this.tireList = tireList;
    }

    public static List<Car> createCars(Storage storage) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            cars.add(new Car(i));
        }
//        System.out.println(cars);
        System.out.println(cars.size());

        //CHANGE RANDOM TIRES

        Random random = new Random();
        for (int j = 0; j < cars.size(); j++) {
            Car car = cars.get(j);
            System.out.println(car);
            for (int i = 0; i < 4; i++) {
                int id = random.nextInt(storage.getSummerTires().size());
                Tire tire = storage.getSummerTires().get(id);
                storage.getSummerTires().remove(id);
                System.out.println(tire);
                car.getTireList().add(tire);

            }
        }
        return cars;
    }

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

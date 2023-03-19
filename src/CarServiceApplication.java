import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CarServiceApplication {
    public static void main(String[] args) {


//Create employees

        List<Customer> customers = new ArrayList<>();
        for (int c = 0; c < 10; c++) {
            customers.add(new Customer(c));
        }

        System.out.println("Total number of customers is: " + customers.size());

        List<Employee> employees = new ArrayList<>();
        for (int y = 0; y < 11; y++) {
            employees.add(new Employee(y));
        }
//        System.out.println(employees);
        System.out.println(employees.size());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            cars.add(new Car(i));
            //            System.out.println(cars.size());
        }
//        System.out.println(cars);
        System.out.println(cars.size());

        List<Tire> summerTires = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            summerTires.add(new Tire(i, "GoodYear"));
        }

        List<Tire> winterTires = new ArrayList<>();
        for (int x = 100; x < 200; x++) {
            winterTires.add(new Tire(x, "GoodYear"));
        }

//        System.out.println(cars);

        Storage storage = new Storage(summerTires, winterTires);
//        storage.setSummerTires(summerTires);
//        storage.getSummerTires();
//        storage.setSummerTires(summerTires);
//        storage.setWinterTires(winterTires);// В чём разница?
        System.out.println("The number of summer tires in the storage: " + storage.getSummerTires().size());
        System.out.println("The number of winter tires in the storage: " + storage.getWinterTires().size());

        Random random = new Random();
//        System.out.println(summerTires);
        for (int j = 0; j < cars.size(); j++) {
            Car car = cars.get(j);
//            System.out.println(car);
            for (int i = 0; i < 4; i++) {
                int id = random.nextInt(storage.getSummerTires().size());
                Tire tire = storage.getSummerTires().get(id);
                storage.getSummerTires().remove(id);
                System.out.println(tire);

                car.getTireList().add(tire);

            }
        }

        System.out.println("Total number of summer tires is: " + summerTires.size());

        System.out.println("Total number of winter tires is: " + winterTires.size());

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
//            for (int j = 0; j < 1; j++) {
                int id = random.nextInt(cars.size());
                Car car = cars.get(id);
//                    cars.remove(8);
                cars.remove(id);
                customer.setCar(car);

//                    System.out.println("Number of customers with cars is " +  car);

//                    System.out.println(customer);
//            }
        }
        System.out.print("[");
        for (int i = 0; i < storage.getSummerTires().size(); i++) {
            Tire tire = storage.getSummerTires().get(i);
            System.out.print(tire.getTireId() + ",");
        }
        System.out.println("]");

        System.out.print("[");
        for (int i = 0; i < storage.getWinterTires().size(); i++) {
            Tire tire = storage.getWinterTires().get(i);
            System.out.print(tire.getTireId() + ",");
        }
        System.out.println("]");

        /////////////////////CHANGE TO WINTER TIRES/////////////////////////////////
        List <Order> orders = new ArrayList<>();
//        for (int i = 0; i < customers.size(); i++) {
//            int id = random.nextInt(customers.size());
//            orders.add(new Order(orders.get(333), customers.get(id), ));
//            long orderNumber, Customer customer, Employee employee, Storage storage, String serviceNeeded)
//
//        }
//        System.out.println(orders.size());
//        System.out.println(orders);
        int ordNum = 1;
        for (int i = 0; i < customers.size(); i++){
            Order order = new Order(ordNum, customers.get(i), employees.get(0), storage, "change tires");
            orders.add(order);
            ordNum++;
          }
        System.out.println(orders);

        for(Order o: orders){
            System.out.println(o.getStatus());
        }

        for(Order o: orders){
            o.fulfill();
        }

        for(Order o: orders){
            System.out.println(o.getStatus());
        }

        System.out.println("||||||||||||||||||||||||||||||||||" + storage.getThisCarTires().toString());





//        Order order = new Order();
//        for (int i = 0; i < 4; i++){
//        order.getCar().getTireList().remove(0);
//        order.getCar().getTireList().add(new Tire(winterTires);
//        }





//            for (int j = 0; j < 4; j++) {
//
//                Tire tire = summerTires.get(id);
////
//                summerTires.remove(id);
//                storage.setSummerTires(summerTires);
//
////            System.out.println(customer.getCar() + customer.getLastName());
//
////            System.out.println(car);
//            } System.out.println(storage.getSummerTires());
////        System.out.println(cars);
//        System.out.println(summerTires);


            //Create customers


            //Create 15 cars
//        storage.takeOfTires();
        }
    }






//        List<Tire> tireListOld = new ArrayList<Tire>(4);
//        tireListOld.remove(new Tire());
//        tireListOld.remove(new Tire());
//        tireListOld.remove(new Tire());
//        tireListOld.remove(new Tire());
//
//        car1.getTires();




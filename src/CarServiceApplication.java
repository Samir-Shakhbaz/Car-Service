import java.util.*;

public class CarServiceApplication {
    public static void main(String[] args) {



        Customer customer = new Customer("Jerry ", "Mouse", new Car());
        Car car1 = new Car("Toyota", "Camry", 2022);
        Employee employee = new Employee("Mike", "1234");
        ServiceOwner owner = new ServiceOwner();

        Order order1 = new Order(customer, car1, employee, 222, "change tires");


        System.out.println(customer.getFirstName() + customer.getLastName() +", owner of: " + car1.getMake() + " , "
                + car1.getModel() + " , " + car1.getYear() + " needs to " + order1.getServiceNeeded() + ". Mechanic assigned: " + employee.getFirstName()
                + ", extension number: " + employee.getPhoneNumber());

        System.out.println(owner.printOwner());

        System.out.println(order1);

        List<Tire> tireList = new ArrayList<Tire>(4);
        tireList.remove(new Tire());
        tireList.remove(new Tire());
        tireList.remove(new Tire());
        tireList.remove(new Tire());

        car1.getTires();


        }
}

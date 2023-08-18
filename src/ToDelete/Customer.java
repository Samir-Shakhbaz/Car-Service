import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer {

    private int id;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    private Car car;

    private long creditCard = 1111222233334444l;


    public Customer (int id, String firstName, String lastName, Car car){
        this.firstName = firstName;
        this.lastName = lastName;
        this.car = car;
    }

    public Customer() {

    }




    //Create employees

    public static List<Customer> createCustomers(List<Car> cars) {

        List<Customer> customers = new ArrayList<>();
        for (int c = 0; c < 10; c++) {
            customers.add(new Customer(c));
        }

        System.out.println("Total number of customers is: " + customers.size());


            Random random = new Random();

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            for (int j = 0; j < 1; j++) {
            int id = random.nextInt(cars.size());
            Car car = cars.get(id);

            cars.remove(id);
            customer.setCar(car);

                System.out.println("Info about customer's car " +  car);
            }


//            System.out.println(customer);
        }

        return customers;
    }




    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }



    public Customer(int c) {

    }

    public String getFirstName() {
        return firstName;
    }



    public String getLastName(){
        return lastName;
    }



    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber (String phoneNumber) { this.phoneNumber = phoneNumber;}



    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", car=" + car +
                '}';
    }


}

import java.util.List;
import java.util.Random;

public class Order {

    private Customer customer;
    private Employee employee;
    private long orderNumber;
    private Storage storage;
    private String serviceNeeded;

    public String getStatus() {
        return status;
    }

    private String status;




    public Order(long orderNumber, Customer customer, Employee employee, Storage storage, String serviceNeeded) {
        this.customer = customer;
        this.employee = employee;
        this.orderNumber = orderNumber;
        this.storage = storage;
        this.serviceNeeded = serviceNeeded;
        this.status = "new";
    }

    public void fulfill(){
        Random random = new Random();
        Car car = customer.getCar();
        for (int i = 0; i < 4; i++) {
            Tire tire = car.getTireList().get(0);
            car.getTireList().remove(0);
            storage.getSummerTires().add(tire);
            System.out.println(tire);
        }


        for (int i = 0; i < 4; i++) {
            int id = random.nextInt(storage.getWinterTires().size());
            Tire tire = storage.getWinterTires().get(id);
            storage.getWinterTires().remove(id);
            System.out.println(tire);

            car.getTireList().add(tire);

        }

        this.status = "closed";

    }

    public void signoff(ServiceOwner serviceOwner){

    this.status = "signed by: " + serviceOwner.printOwner();

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getServiceNeeded() {
        return serviceNeeded;
    }

    public void setServiceNeeded(String serviceNeeded) {
        this.serviceNeeded = serviceNeeded;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", employee=" + employee +
                ", orderNumber=" + orderNumber +
                ", status=" + status +
                ", serviceNeeded='" + serviceNeeded + '\'' +
                '}';
    }
}

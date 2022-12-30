import java.util.List;

public class Order {

    private Customer customer;
    private Car car;
    private Employee employee;
    private long orderNumber;
    private String serviceNeeded;

    public Order(Customer customer, Car car, Employee employee, long orderNumber, String serviceNeeded) {
        this.customer = customer;
        this.car = car;
        this.employee = employee;
        this.orderNumber = orderNumber;
        this.serviceNeeded = serviceNeeded;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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
                ", car=" + car +
                ", employee=" + employee +
                ", orderNumber=" + orderNumber +
                ", serviceNeeded='" + serviceNeeded + '\'' +
                '}';
    }
}

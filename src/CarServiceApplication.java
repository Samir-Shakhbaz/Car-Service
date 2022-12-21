public class CarServiceApplication {
    public static void main(String[] args) {

        Customer customer1 = new Customer();
        Car car1 = new Car();
        customer1.setFirstName("John");


        System.out.println(customer1.getFirstName() + customer1.getLastName());

        Order order1 = new Order();
        order1.setCustomer(customer1);
        order1.setOrderNumber(123);
        order1.setMechanicName("Mike");
        order1.setServiceNeeded("Change tires");
        order1.customer.setFirstName("Bob");
        order1.customer.setLastName("Pedroso");
        order1.customer.setPhoneNumber("1234");
        order1.customer.car1.setModel("Ford");
        System.out.println(customer1.getFirstName());
    }
}

public class Customer {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Car car;

public Customer (String firstName, String lastName, Car car){
    this.firstName = firstName;
    this.lastName = lastName;
    this.car = car;
}

    public String getFirstName() {
        return firstName;
    }



    public String getLastName(){
        return lastName;
    }



    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber (String phoneNumber) { this.phoneNumber = phoneNumber;}

Car car1 = new Car();

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", car=" + car +
                ", car1=" + car1 +
                '}';
    }
}

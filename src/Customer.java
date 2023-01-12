public class Customer {

    private int id;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    private Car car;

    private long creditCard = 1111222233334444l;


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }




public Customer (int id, String firstName, String lastName, Car car){
    this.firstName = firstName;
    this.lastName = lastName;
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

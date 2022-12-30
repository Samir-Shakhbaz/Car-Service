public class Tire {

    private String make;

    public Tire(){}

    public Tire(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String toString() {
        return "Tire{" +
                "make='" + make + '\'' +
                '}';
    }
}

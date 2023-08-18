public class Tire {

    private int tireId;
    private String make;



    public Tire(int tireId, String make) {
        this.tireId = tireId;
        this.make = make;
    }

    public int getTireId() {
        return tireId;
    }

    public void setTireId(int tireId) {
        this.tireId = tireId;
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
                "tireId=" + tireId +
                ", make='" + make + '\'' +
                '}';
    }
}




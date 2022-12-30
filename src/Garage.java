import java.util.ArrayList;
import java.util.List;

public class Garage {

    public Garage(List<Tire> tireStock) {
        this.tireStock = tireStock;
    }

    List<Tire> tireStock = new ArrayList<>(100);

}

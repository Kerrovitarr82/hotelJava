import java.util.Comparator;

public class ServicePriceComparator implements Comparator<Service> {
    @Override
    public int compare(Service o1, Service o2) {
        if (o1.getPrice() >= o2.getPrice()) {
            return 1;
        } else if (o1.getPrice() < o2.getPrice()) {
            return -1;
        } else {
            return 0;
        }
    }
}

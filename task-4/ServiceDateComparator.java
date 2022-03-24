import java.util.Comparator;

public class ServiceDateComparator implements Comparator<Service> {
    @Override
    public int compare(Service o1, Service o2) {
        if (o1.getDate().getTimeInMillis() >= o2.getDate().getTimeInMillis()) {
            return 1;
        } else if (o1.getDate().getTimeInMillis() < o2.getDate().getTimeInMillis()) {
            return -1;
        } else {
            return 0;
        }
    }
}

import java.text.SimpleDateFormat;
import java.util.*;

public class Guest {
    private String name;
    private Room room;
    private int totalPrice;
    private Calendar firstDay;
    private Calendar lastDay;
    private List<Service> services = new ArrayList<>();


    Guest(String name, int days) {
        this.name = name;
        this.firstDay = new GregorianCalendar();
        this.lastDay = new GregorianCalendar();
        lastDay.add(Calendar.DAY_OF_YEAR, days);
        this.totalPrice = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Calendar getLastDay() {
        return lastDay;
    }

    public void setLastDay(Calendar lastDay) {
        this.lastDay = lastDay;
    }

    public Calendar getFirstDay() {
        return firstDay;
    }

    public void addService(Service service) {
        this.services.add(service);
    }

    public List<Service> getServices() {
        return services;
    }

    public int getTotalPrice() {
        countTotalPrice();
        return totalPrice;
    }

    public void countTotalPrice() {
        Date date1 = new Date();
        Date date2 = lastDay.getTime();
        totalPrice = (int) (room.getPrice() * ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1));
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd.MM.yyyy");
        return "Guest{" +
                "name='" + name + '\'' +
                ", room=" + room.getNumber() +
                ", services=" + services +
                ", firstDay=" + simpleDateFormat.format(firstDay.getTime()) +
                ", lastDay=" + simpleDateFormat.format(lastDay.getTime()) +
                '}';
    }

}

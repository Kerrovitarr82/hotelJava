import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Service {
    private String name;
    private int price;
    private int id;
    private Calendar date;

    public Service(String name, int price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public Service(String name, int price, int id, Calendar date) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDate() {
        return date;
    }

    @Override
    public String toString() {
        if (date == null) {
            return "Service{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", id=" + id +
                    '}';
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd.MM.yyyy hh:mm");
            return "Service{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", id=" + id +
                    ", date=" + simpleDateFormat.format(date.getTime()) +
                    '}';
        }
    }
}

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Room {
    private int number;
    private Status status;
    private int price;
    private int maxGuests;
    private int stars;
    private List<Guest> guests = new ArrayList<>();
    private Queue<Guest> lastThreeGuest = new LinkedList<>();

    public Room(int number, Status status, int price, int maxGuests, int stars) {
        this.number = number;
        this.status = status;
        this.price = price;
        this.maxGuests = maxGuests;
        this.stars = stars;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(Guest guest) {
        if (guest == null) {
            this.guests.clear();
        } else {
            this.guests.add(guest);
            if (this.lastThreeGuest.size() < 3) {
                this.lastThreeGuest.add(guest);
            } else {
                this.lastThreeGuest.poll();
                this.lastThreeGuest.add(guest);
            }
        }
    }

    public void checkLastThreeGuest() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd.MM.yyyy");
        for (Guest guest : lastThreeGuest) {
            System.out.println("Имя: " + guest.getName() +
                    ". Дата заезда: " + simpleDateFormat.format(guest.getFirstDay().getTime()) +
                    ". Дата выезда: " + simpleDateFormat.format(guest.getLastDay().getTime()));
        }
    }

    @Override
    public String toString() {
        if (guests.size() != 0) {
            return "Room{" +
                    "number=" + number +
                    ", status=" + status +
                    ", price=" + price +
                    ", maxGuests=" + maxGuests +
                    ", stars=" + stars +
                    ", guests=" + guests +
                    '}';
        } else {
            return "Room{" +
                    "number=" + number +
                    ", status=" + status +
                    ", price=" + price +
                    ", maxGuests=" + maxGuests +
                    ", stars=" + stars +
                    '}';
        }

    }
}

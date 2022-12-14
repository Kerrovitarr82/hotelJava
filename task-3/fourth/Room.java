package fourth;

public class Room {
    private int number;
    private Status status;
    private int price;
    private Guest guest;

    public Room(int number, Status status, int price, Guest guest) {
        this.number = number;
        this.status = status;
        this.price = price;
        this.guest = guest;
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

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", guest=" + guest +
                '}';
    }
}

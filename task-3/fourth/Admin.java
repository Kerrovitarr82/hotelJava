package fourth;

import java.util.ArrayList;
import java.util.Arrays;

public class Admin {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Service> services = new ArrayList<>();
    private ArrayList<Guest> guests = new ArrayList<>(Arrays.asList(new Guest[10]));

    public Admin() {
        rooms.add(new Room(1, "none", 1000, null));
        rooms.add(new Room(2, "none", 1000, null));
        rooms.add(new Room(3, "none", 2000, null));
        rooms.add(new Room(4, "none", 2000, null));
        rooms.add(new Room(5, "none", 3000, null));
        services.add(new Service("Завтрак", 200));
    }

    public void addToRoom(int roomNum, Guest guest) {
        rooms.get(roomNum).setGuest(guest);
        //guest.setRoom(rooms.get(roomNum));
        guests.set(roomNum, guest);
    }

    public void deleteFromRoom(int roomNum) {
        //rooms.get(roomNum).getGuest().setRoom(null);
        rooms.get(roomNum).setGuest(null);
        guests.set(roomNum, null);
    }

    public void underRepair(int roomNum) {
        rooms.get(roomNum).setStatus("Ремонт");
    }

    public void serviced(int roomNum) {
        rooms.get(roomNum).setStatus("Обслуживается");
    }

    public void changePriceToRoom(int roomNum, int price) {
        rooms.get(roomNum).setPrice(price);
    }

    public void changePriceToService(String name, int price) {
        for (Service service : services) {
            if (service.getName() == name) {
                service.setPrice(price);
                break;
            }
        }
    }

    public void addRoom(int price) {
        rooms.add(new Room(rooms.size(), "none", price, null));
    }

    public void addService(String name, int price) {
        services.add(new Service(name, price));
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public void setGuests(ArrayList<Guest> guests) {
        this.guests = guests;
    }
}

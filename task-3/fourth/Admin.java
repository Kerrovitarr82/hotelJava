package fourth;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Room> rooms = new ArrayList<>();
    private List<Service> services = new ArrayList<>();

    public Admin() {
        rooms.add(new Room(1, Status.NONE, 1000, null));
        rooms.add(new Room(2, Status.NONE, 1000, null));
        rooms.add(new Room(3, Status.NONE, 2000, null));
        rooms.add(new Room(4, Status.NONE, 2000, null));
        rooms.add(new Room(5, Status.NONE, 3000, null));
        services.add(new Service("Завтрак", 200, 1));
    }

    public void addToRoom(int roomNum, Guest guest) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNum) {
                room.setGuest(guest);
                guest.setRoom(room);
                break;
            }
        }
    }

    public void deleteFromRoom(int roomNum) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNum) {
                room.getGuest().setRoom(null);
                room.setGuest(null);
                break;
            }
        }
    }

    public void changeStatus(int roomNum, Status status) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNum) {
                room.setStatus(status);
                break;
            }
        }
    }

    public void changePriceToRoom(int roomNum, int price) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNum) {
                room.setPrice(price);
                break;
            }
        }
    }

    public void changePriceToService(int id, int price) {
        for (Service service : services) {
            if (service.getId() == id) {
                service.setPrice(price);
                break;
            }
        }
    }

    public void addRoom(int price, int roomNum) {
        rooms.add(new Room(roomNum, Status.NONE, price, null));
    }

    public void addService(String name, int price, int id) {
        services.add(new Service(name, price, id));
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room getRoom(int roomNum) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNum) {
                return room;
            }
        }
        return null;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }
}

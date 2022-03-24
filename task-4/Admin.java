import java.util.*;

public class Admin {
    private List<Room> rooms = new ArrayList<>();
    private List<Service> services = new ArrayList<>();
    private List<Guest> allGuests = new ArrayList<>();

    public Admin() {
        rooms.add(new Room(1, Status.FREE, 1000, 1, 2));
        rooms.add(new Room(2, Status.FREE, 1000, 2, 1));
        rooms.add(new Room(3, Status.FREE, 2000, 1, 3));
        rooms.add(new Room(4, Status.FREE, 2000, 2, 2));
        rooms.add(new Room(5, Status.FREE, 3000, 2, 3));
        services.add(new Service("Завтрак", 300, 1));
        services.add(new Service("Обед", 500, 2));
        services.add(new Service("Перекус", 200, 3));
    }

    public void addToRoom(int roomNum, Guest guest) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNum) {
                room.setGuests(guest);
                room.setStatus(Status.SERVICED);
                guest.setRoom(room);
                this.allGuests.add(guest);
                break;
            }
        }
    }

    public void deleteFromRoom(int roomNum) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNum) {
                for (Guest guest : room.getGuests()) {
                    guest.setRoom(null);
                    this.allGuests.remove(guest);
                }
                room.setGuests(null);
                room.setStatus(Status.FREE);
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

    public void addRoom(int price, int roomNum, int maxGuests, int stars) {
        rooms.add(new Room(roomNum, Status.FREE, price, maxGuests, stars));
    }

    public void addService(String name, int price, int id) {
        services.add(new Service(name, price, id));
    }

    public void addServiceToGuest(int serviceId, Calendar serviceDate, String name) {
        for (Guest guest : allGuests) {
            if (name == guest.getName()) {
                for (Service service : services) {
                    if (service.getId() == serviceId) {
                        guest.addService(new Service(service.getName(), service.getPrice(), serviceId, serviceDate));
                        break;
                    }
                }
            }
        }
    }

    public void getTotalPriceForGuest(String name) {
        for (Guest guest : allGuests) {
            if (guest.getName() == name) {
                System.out.println(guest.getTotalPrice());
                break;
            }
        }
    }

    public int totalNumberOf(Choice choice) {
        int total = 0;
        switch (choice) {
            case FREE_ROOMS:
                total = rooms.size() - allGuests.size();
                break;
            case GUESTS:
                total = allGuests.size();
                break;
        }
        return total;
    }

    public List<Room> listOfFreeRoomsByDate(Calendar date) {
        List<Room> roomList = new ArrayList<>();
        for (Room room : this.rooms) {
            if (room.getGuests().size() == 0) {
                roomList.add(room);
            } else if (date.after(room.getGuests().get(0).getLastDay())) {
                roomList.add(room);
            }
        }
        return roomList;
    }

    public void printFunc(Collection collection) {
        for (Object item : collection) {
            System.out.println(item);
        }
    }

    public void allRoomsSort() {
        Comparator<Room> roomComparator = new RoomPriceComparator().thenComparing(new RoomMaxGuestsComparator()).thenComparing(new RoomStarsComparator());
        Set<Room> roomTreeSet = new TreeSet<>(roomComparator);
        roomTreeSet.addAll(rooms);
        printFunc(roomTreeSet);
    }

    public void freeRoomsSort() {
        Comparator<Room> roomComparator = new RoomPriceComparator().thenComparing(new RoomMaxGuestsComparator()).thenComparing(new RoomStarsComparator());
        Set<Room> roomTreeSet = new TreeSet<>(roomComparator);
        for (Room room : rooms) {
            if (room.getStatus() == Status.FREE) {
                roomTreeSet.add(room);
            }
        }
        printFunc(roomTreeSet);
    }

    public void guestSort() {
        Comparator<Guest> guestComparator = new GuestAlphabetComparator().thenComparing(new GuestDateComparator());
        Set<Guest> guestTreeSet = new TreeSet<>(guestComparator);
        guestTreeSet.addAll(allGuests);
        printFunc(guestTreeSet);
    }

    public void roomsAndServicesSort() {
        Comparator<Room> roomComparator = new RoomPriceComparator();
        Comparator<Service> serviceComparator = new ServicePriceComparator();
        Set<Room> roomTreeSet = new TreeSet<>(roomComparator);
        Set<Service> serviceTreeSet = new TreeSet<>(serviceComparator);
        roomTreeSet.addAll(rooms);
        serviceTreeSet.addAll(services);
        printFunc(roomTreeSet);
        printFunc(serviceTreeSet);
    }

    public void guestServicesSort(String name) {
        Comparator<Service> serviceComparator = new ServicePriceComparator().thenComparing(new ServiceDateComparator());
        Set<Service> serviceTreeSet = new TreeSet<>(serviceComparator);
        for (Guest guest : allGuests) {
            if (guest.getName() == name) {
                serviceTreeSet.addAll(guest.getServices());
                break;
            }
        }
        printFunc(serviceTreeSet);
    }

    public void getSorted(Choice choice) {
        switch (choice) {
            case ALL_ROOMS:
                allRoomsSort();
                break;
            case FREE_ROOMS:
                freeRoomsSort();
                break;
            case GUESTS:
                guestSort();
                break;
            case ROOMS_AND_SERVICES:
                roomsAndServicesSort();
                break;
        }
    }

    public void getSorted(String name) {
        guestServicesSort(name);
    }

    public void getLastThreeGuest(int roomNum) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNum) {
                room.checkLastThreeGuest();
                break;
            }
        }
    }

    public void roomDetails(int roomNum) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNum) {
                System.out.println(room);
                break;
            }
        }
    }

    public List<Room> getRooms() {
        return this.rooms;
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
        return this.services;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    public List<Guest> getAllGuests() {
        return allGuests;
    }
}

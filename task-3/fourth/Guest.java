package fourth;

public class Guest {
    private String name;
    //private Room room;

    Guest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Room getRoom() {
//        return room;
//    }

//    public void setRoom(Room room) {
//        this.room = room;
//    }

//    @Override
//    public String toString() {
//        return "Guest{" +
//                "name='" + name + '\'' +
//                ", room=" + room +
//                '}';
//    }


    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                '}';
    }
}

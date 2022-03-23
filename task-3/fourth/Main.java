package fourth;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Guest guest1 = new Guest("Вова");
        Guest guest2 = new Guest("Федя");
        System.out.println("\n" + admin.getRooms().toString() + "\n");
        System.out.println(admin.getServices().toString() + "\n");

        admin.addToRoom(1, guest1);
        admin.addToRoom(4, guest2);
        System.out.println("Заселили двух гостей в 1 и 4 номера");
        System.out.println(admin.getRoom(1).toString());
        System.out.println(admin.getRoom(4).toString() + "\n");

        admin.deleteFromRoom(1);
        System.out.println("Выселили гостя из 1 номера");
        System.out.println(admin.getRoom(1).toString() + "\n");

        admin.changeStatus(3, Status.UNDER_REPAIR);
        System.out.println("Отправили 3 номер на ремонт");
        System.out.println(admin.getRoom(3).toString() + "\n");

        admin.changeStatus(4, Status.SERVICED);
        System.out.println("Отправили 4 номер на обслуживание");
        System.out.println(admin.getRoom(4).toString() + "\n");

        admin.changePriceToRoom(5, 7000);
        System.out.println("Изменили цену на 5 номер");
        System.out.println(admin.getRoom(5).toString() + "\n");

        admin.changePriceToService(1, 500);
        System.out.println("Изменили цену на услугу <<Завтрак>>");
        for (Service service : admin.getServices()) {
            if (service.getId() == 1) {
                System.out.println(service + "\n");
                break;
            }
        }

        admin.addRoom(10000, 6);
        System.out.println("Добавили номер 6 с ценой 10000");
        System.out.println(admin.getRoom(6).toString() + "\n");

        admin.addService("Обед", 500, 2);
        System.out.println("Добавили новую услугу <<Обед>> с ценой 500");
        System.out.println(admin.getServices().toString());

    }
}

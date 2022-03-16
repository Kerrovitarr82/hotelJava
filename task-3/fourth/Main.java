package fourth;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Guest guest1 = new Guest("Вова");
        Guest guest2 = new Guest("Федя");
        System.out.println(admin.getRooms().toString());
        System.out.println(admin.getServices().toString());

        admin.addToRoom(1 - 1, guest1);                        // тут и далее -1 нужен для корректной записи в ArrayList
        admin.addToRoom(4 - 1, guest2);                        // (в будущем скорее всего придется заменить первую цифру на переменную типа int,
        System.out.println("Заселили двух гостей в 1 и 4 номера");      // которую будет с клавиатуры вводить юзер)
        System.out.println(admin.getRooms().get(1 - 1).toString());
        System.out.println(admin.getRooms().get(4 - 1).toString() + "\n");

        admin.deleteFromRoom(1 - 1);
        System.out.println("Выселили гостя из 1 номера");
        System.out.println(admin.getRooms().get(1 - 1).toString() + "\n");

        admin.underRepair(3 - 1);
        System.out.println("Отправили 3 номер на ремонт");
        System.out.println(admin.getRooms().get(3 - 1).toString() + "\n");

        admin.serviced(4 - 1);
        System.out.println("Отправили 4 номер на обслуживание");
        System.out.println(admin.getRooms().get(4 - 1).toString() + "\n");

        admin.changePriceToRoom(5 - 1, 7000);
        System.out.println("Изменили цену на 5 номер");
        System.out.println(admin.getRooms().get(5 - 1).toString() + "\n");

        admin.changePriceToService("Завтрак", 500);
        System.out.println("Изменили цену на услугу <<Завтрак>>");
        for (Service service : admin.getServices()) {
            if (service.getName() == "Завтрак") {
                System.out.println(service.toString());
                break;
            }
        }

        admin.addRoom(10000);
        System.out.println("Добавили номер 6 с ценой 10000");
        System.out.println(admin.getRooms().get(6 - 1).toString() + "\n");

        admin.addService("Обед", 500);
        System.out.println("Добавили новую услугу <<Обед>> с ценой 500");
        System.out.println(admin.getServices().toString());

    }
}

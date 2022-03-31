import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Guest guest1 = new Guest("Владимир Панов", 30);
        Guest guest2 = new Guest("Федор Довлатов", 12);
        Guest guest3 = new Guest("Дмитрий Нар", 30);

        admin.addToRoom(2, new Guest("Test", 10));
        admin.deleteGuest(2);
        admin.addToRoom(2, new Guest("Test", 20));
        admin.deleteGuest(2);
        admin.addToRoom(2, new Guest("Test", 30));
        admin.deleteGuest(2);

        System.out.println("\nСписок всех номеров с сортировкой по цене, вместимости и кол-ву звезд");
        admin.getSorted(SortAndTotalChoice.ALL_ROOMS);

        System.out.println("\nДобавим постояльца в 1 (Владимира Панова) номер");
        admin.addToRoom(1, guest1);

        System.out.println("\nСписок всех свободных номеров с сортировкой по цене, вместимости и кол-ву звезд");
        admin.getSorted(SortAndTotalChoice.FREE_ROOMS);

        System.out.println("\nДобавим еще двух постояльцев в 3 (Федора Довлатова) и 5 (Дмитрия Нар) номера");
        admin.addToRoom(3, guest2);
        admin.addToRoom(5, guest3);

        System.out.println("\nСписок всех постояльцев с сортировкой по алфавиту и дате освобождения номера");
        admin.getSorted(SortAndTotalChoice.GUESTS);

        System.out.println("\nОбщее число свободных номеров: " + admin.totalNumberOf(SortAndTotalChoice.FREE_ROOMS));

        System.out.println("\nОбщее число постояльцев: " + admin.totalNumberOf(SortAndTotalChoice.GUESTS));

        System.out.println("\nСписок номеров, которые будут свободны по определенной дате в будущем (6 апреля)");
        System.out.println(admin.listOfFreeRoomsByDate(new GregorianCalendar(2022, Calendar.APRIL, 6)));

        System.out.println("\nСумма оплаты за номер, которую должен заплатить гость (Владимир Панов)");
        admin.getTotalPriceForGuest("Владимир Панов");

        System.out.println("\nТри последних постояльца номера (2) и даты их пребывания");
        admin.getLastThreeGuest(2);

        System.out.println("Добавим Владимиру Панову несколько услуг");
        admin.addServiceToGuest(1, new GregorianCalendar(2022, Calendar.MARCH, 30, 12, 0), "Владимир Панов");
        admin.addServiceToGuest(3, new GregorianCalendar(2022, Calendar.MARCH, 25, 12, 0), "Владимир Панов");
        admin.addServiceToGuest(2, new GregorianCalendar(2022, Calendar.MARCH, 30, 12, 0), "Владимир Панов");

        System.out.println("\nСписок услуг гостя (Владимира Панова) и их цена, отсортированный по цене и дате");
        admin.getSorted("Владимир Панов");

        System.out.println("\nЦены услуг и номеров");
        admin.getSorted(SortAndTotalChoice.ROOMS_AND_SERVICES);

        System.out.println("\nДетали отдельно взятого номера (первого)");
        admin.roomDetails(1);
    }
}

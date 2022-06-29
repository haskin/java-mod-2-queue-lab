import java.util.UUID;

public class Table {
    private static boolean oneIsAvaliable = true;
    private static boolean twoIsAvaliable = true;

    public static boolean getOneIsAvaliable() {
        return oneIsAvaliable;
    }

    public static boolean getTwoIsAvaliable() {
        return twoIsAvaliable;
    }

    private static boolean isAvailable() {
        return oneIsAvaliable || twoIsAvaliable;
    }

    public static void checkIn(UUID customerId) {
        if (!isAvailable()) {
            System.out.println("No tables are currently available");
            Reservations.addCustomer(customerId);
            return;
        }

        // If the queue is not empty, get customer in front of queue
        // and put the current customer at the end of the queue
        if (!Reservations.isEmpty()) {
            Reservations.addCustomer(customerId);
            Reservations.removeCustomer();
        }

        if (oneIsAvaliable) {
            oneIsAvaliable = false;
            return;
        }

        if (twoIsAvaliable)
            twoIsAvaliable = false;

    }

    public static void checkOut() {
        if (!oneIsAvaliable) {
            oneIsAvaliable = true;
            return;
        }

        if (!twoIsAvaliable)
            twoIsAvaliable = true;

    }
}

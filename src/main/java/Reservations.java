import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.UUID;

/**
 * Reservation
 */
public class Reservations {
    private static Queue<UUID> queue = new LinkedList<>();

    private Reservations() {
    }

    public static void addCustomer(UUID customerId) {
        queue.add(customerId);
    }

    public static void removeCustomer() {
        try {
            queue.remove();
        } catch (NoSuchElementException e) {
            System.out.println("ERROR: Cannot remove customer from empty queue.");
        }
    }

    public static boolean isEmpty() {
        return queue.isEmpty();
    }

    public static String print() {
        return queue.toString();
    }

}
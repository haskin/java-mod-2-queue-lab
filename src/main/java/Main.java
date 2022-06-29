import java.util.Scanner;
import java.util.UUID;

public class Main {

    // x Our restaurant has 2 tables
    // x In an input loop, ask the user if they want to check someone in or check
    // someone out
    // x If they want to check someone in, check if a table is available.
    // x If a table is available, check them in
    // x If a table is not available, put them on a waiting list
    // If they want to check someone out:
    // Free one of the table that is taken
    // Immediately assign the table to the next person on the waiting list
    public static void main(String[] args) {
        System.out.println("\n----Reservation System ----");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Do you want to check someone in(I) or out(o)? (I/o): ");
                if (scanner.nextLine().equalsIgnoreCase("o")) {
                    Table.checkOut();
                } else
                    Table.checkIn(UUID.randomUUID());

                System.out.println(String.format("Table One Available: %s, Table Two Available: %s",
                        Table.getOneIsAvaliable(), Table.getTwoIsAvaliable()));
                System.out.println(String.format("Reservation List: %s", Reservations.print()));
                System.out.print("\nAre you done with the Reservation System? (y/N): ");
                boolean isDone = scanner.nextLine().equalsIgnoreCase("y");
                if (isDone)
                    return;

                System.out.println();
            }
        }
    }
}

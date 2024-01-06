package api_assignment;

//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TicketApi {
	private static Scanner scanner = new Scanner(System.in);
	
    private static Map<User, Seat> userSeatMap = new HashMap<>();

    public static String submitPurchase(String from, String to, String firstName, String lastName, String email, double pricePaid, String section) {
        User user = new User(firstName, lastName, email);
        Purchase purchase = new Purchase(from, to, user, pricePaid);

        // Allocate a seat for the user in the specified section
        Seat seat = allocateSeat(section);
        userSeatMap.put(user, seat);

        return generateReceipt(purchase, seat);
    }

    private static String generateReceipt(Purchase purchase, Seat seat) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Receipt Details:\n");
        receipt.append("From: ").append(purchase.getFrom()).append("\n");
        receipt.append("To: ").append(purchase.getTo()).append("\n");
        receipt.append("User: ").append(purchase.getUser().getFullName()).append("\n");
        receipt.append("Email: ").append(purchase.getUser().getEmail()).append("\n");
        receipt.append("Price Paid: $").append(purchase.getPricePaid()).append("\n");
        receipt.append("Seat Section: ").append(seat.getSection()).append("\n");
        receipt.append("Seat Number: ").append(seat.getNumber()).append("\n");
        receipt.append("Purchase Date: ").append(purchase.getPurchaseDate()).append("\n");

        return receipt.toString();
    }

    public static void viewUsersAndSeats(String section) {
        System.out.println("Users and Seats in Section " + section + ":\n");
        for (Map.Entry<User, Seat> entry : userSeatMap.entrySet()) {
            User user = entry.getKey();
            Seat seat = entry.getValue();
            if (seat.getSection().equals(section)) {
                System.out.println("User: " + user.getFullName() + ", Seat: " + seat.getNumber());
            }
        }
        System.out.println();
    }

    public static void removeUser(User user) {
        if (userSeatMap.containsKey(user)) {
            Seat seat = userSeatMap.get(user);
            System.out.println("Removing user " + user.getFullName() + " from Seat " + seat.getNumber());
            userSeatMap.remove(user);
        } else {
            System.out.println("User not found in the system.");
        }
    }

    public static void modifyUserSeat(User user, String newSection, int newSeatNumber) {
        if (userSeatMap.containsKey(user)) {
            Seat oldSeat = userSeatMap.get(user);
            Seat newSeat = new Seat(newSection, newSeatNumber);
            userSeatMap.put(user, newSeat);

            System.out.println("Modifying user " + user.getFullName() + "'s seat from " +
                    oldSeat.getSection() + " " + oldSeat.getNumber() + " to " +
                    newSeat.getSection() + " " + newSeat.getNumber());
        } else {
            System.out.println("User not found in the system.");
        }
    }
    
 //seat allocation logic
    private static Seat allocateSeat(String section) {
        
        int nextSeatNumber = userSeatMap.size() + 1;
        return new Seat(section, nextSeatNumber);
    }
    
    

    public static void main(String[] args) {
    	System.out.println("Hello, Welcome to Train Ticketing system");
        while (true) {
            System.out.println("\nTrain Ticketing System Menu:");
            System.out.println("1. Submit a Purchase");
            System.out.println("2. View Users and Seats");
            System.out.println("3. Remove a User");
            System.out.println("4. Modify a User's Seat");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    submitPurchaseFromUserInput();
                    break;
                case 2:
                    viewUsersAndSeatsFromUserInput();
                    break;
                case 3:
                    removeUserFromUserInput();
                    break;
                case 4:
                    modifyUserSeatFromUserInput();
                    break;
                case 5:
                    System.out.println("Exiting the Train Ticketing System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void submitPurchaseFromUserInput() {
        System.out.println("\nSubmit a Purchase:");
        System.out.print("From: ");
        String from = scanner.nextLine();

        System.out.print("To: ");
        String to = scanner.nextLine();

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Price Paid: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Seat Section (e.g., Section A): ");
        String section = scanner.nextLine();

        String receipt = submitPurchase(from, to, firstName, lastName, email, price, section);
        System.out.println(receipt);
    }

    private static void viewUsersAndSeatsFromUserInput() {
        System.out.print("\nView Users and Seats in Section (e.g., Section A): ");
        String section = scanner.nextLine();
        viewUsersAndSeats(section);
    }

    private static void removeUserFromUserInput() {
        System.out.print("\nRemove User (Enter email): ");
        String email = scanner.nextLine();
        User userToRemove = getUserByEmail(email);

        if (userToRemove != null) {
            removeUser(userToRemove);
            System.out.println("User removed successfully.");
        } else {
            System.out.println("User not found in the system.");
        }
    }

    private static void modifyUserSeatFromUserInput() {
        System.out.print("\nModify User's Seat (Enter email): ");
        String email = scanner.nextLine();
        User userToModify = getUserByEmail(email);

        if (userToModify != null) {
            System.out.print("New Seat Section: ");
            String newSection = scanner.nextLine();

            System.out.print("New Seat Number: ");
            int newSeatNumber = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            modifyUserSeat(userToModify, newSection, newSeatNumber);
            System.out.println("User's seat modified successfully.");
        } else {
            System.out.println("User not found in the system.");
        }
    }

    private static User getUserByEmail(String email) {
        for (User user : userSeatMap.keySet()) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }
}

class Seat {
    private String section;
    private int number;

    public Seat(String section, int number) {
        this.section = section;
        this.number = number;
    }

    public String getSection() {
        return section;
    }

    public int getNumber() {
        return number;
    }
}
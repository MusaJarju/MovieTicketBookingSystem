import java.util.ArrayList;
import java.util.Scanner;

public class MovieTicketBookingSystem {
    private static ArrayList<Show> shows = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeShows();
        int choice;

        do {
            System.out.println("\n🎬 Welcome to Movie Ticket Booking System");
            System.out.println("1. View All Shows");
            System.out.println("2. Book a Seat");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewShows();
                    break;
                case 2:
                    bookSeat();
                    break;
                case 3:
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private static void initializeShows() {
        Movie m1 = new Movie("Inception", "Sci-Fi", 148);
        Movie m2 = new Movie("Interstellar", "Adventure", 169);
        Movie m3 = new Movie("The Dark Knight", "Action", 152);

        shows.add(new Show(m1, "10:00 AM", 10));
        shows.add(new Show(m2, "1:00 PM", 8));
        shows.add(new Show(m3, "5:00 PM", 12));
    }

    private static void viewShows() {
        System.out.println("\n📺 Available Shows:");
        for (int i = 0; i < shows.size(); i++) {
            Show show = shows.get(i);
            System.out.println((i + 1) + ". " + show.getMovie() + " at " + show.getShowTime());
        }
    }

    private static void bookSeat() {
        viewShows();
        System.out.print("Select a show (number): ");
        int showIndex = scanner.nextInt() - 1;

        if (showIndex < 0 || showIndex >= shows.size()) {
            System.out.println("❌ Invalid show selection.");
            return;
        }

        Show selectedShow = shows.get(showIndex);
        selectedShow.displaySeats();

        System.out.print("Enter seat number to book: ");
        int seatNumber = scanner.nextInt();

        boolean booked = selectedShow.bookSeat(seatNumber);
        if (booked) {
            System.out.println("✅ Seat " + seatNumber + " successfully booked!");
        } else {
            System.out.println("❌ Seat already booked or invalid number.");
        }
    }
}


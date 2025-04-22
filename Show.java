import java.util.ArrayList;

public class Show {
    private Movie movie;
    private String showTime;
    private ArrayList<Seat> seats;

    public Show(Movie movie, String showTime, int totalSeats) {
        this.movie = movie;
        this.showTime = showTime;
        seats = new ArrayList<>();
        for (int i = 1; i <= totalSeats; i++) {
            seats.add(new Seat(i));
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public String getShowTime() {
        return showTime;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void displaySeats() {
        for (Seat seat : seats) {
            System.out.println(seat);
        }
    }

    public boolean bookSeat(int seatNumber) {
        if (seatNumber < 1 || seatNumber > seats.size()) return false;
        Seat seat = seats.get(seatNumber - 1);
        if (!seat.isBooked()) {
            seat.book();
            return true;
        }
        return false;
    }
}


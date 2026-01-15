package cinema.service;

import cinema.domain.Seat;
import cinema.domain.Show;
import cinema.util.Auditorium;
import java.util.ArrayList;
import java.util.List;

//Znowu kompletny rework

public class SeatMapService
{

    public List<Seat> generateSeatMap(Auditorium auditorium)
    {
        List<Seat> seats = new ArrayList<>();
        if (auditorium == null) {
            throw new IllegalArgumentException("Nie ma audytorium");
        }
        for (int row = 1; row <= auditorium.getRows(); row++)
        {
            int seatsInCurrentRow = auditorium.seatsInRow(row);
            for (int number = 1; number <= seatsInCurrentRow; number++)
            {
                seats.add(new Seat(row, number));
            }
        }
        return seats;
    }

    //Wizualizacja
    public void printSeatMap(Show show)
    {
        List<Seat> seats = show.getSeats();
        if (seats == null || seats.isEmpty())
        {
            System.out.println("Brak mapy miejsc dla seansu");
            return;
        }

        System.out.println(); System.out.println("EKRAN (" + show.getAuditorium().getName() + " - " + show.getMovieTitle() + ")");
        System.out.println("------------------------------");

        int currentRow = 1;
        for (Seat seat : seats)
        {
            //Nowa linijka
            if (seat.getRow() > currentRow)
            {
                System.out.println();
                currentRow = seat.getRow();
            }

            //Ciekawy trick jaki znalazłem na sieci
            String symbol = seat.isAvailable() ? "[O]" : "[X]";
            System.out.print(symbol + " ");
        }
        System.out.println(); System.out.println("------------------------------");
    }
}
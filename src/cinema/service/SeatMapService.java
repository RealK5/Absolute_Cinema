package cinema.service;

import cinema.domain.Seat;
import cinema.util.Auditorium;
import java.util.ArrayList;
import java.util.List;

public class SeatMapService
{
    public List<Seat> generateSeatMap(Auditorium auditorium)
    {
        List<Seat> seats = new ArrayList<>();

        if (auditorium == null)
        {
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
}
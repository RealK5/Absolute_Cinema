package cinema.util;

import cinema.domain.Exportable;
import cinema.domain.Seat;
import cinema.domain.Show;
import java.math.BigDecimal;

public abstract class Ticket implements Exportable
{
    private final Show show;
    private final Seat seat;
    private final BigDecimal price;

    public Ticket(Show show, Seat seat, BigDecimal price)
    {
        this.show = show;
        this.seat = seat;
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public Show getShow()
    {
        return show;
    }

    public Seat getSeat()
    {
        return seat;
    }

    @Override
    public String toCsv()
    {
        return show.getMovieTitle() + "," + show.getAuditorium().getName() + "," + show.getStartTime() + "," + seat.getRow() + "," + seat.getNumber() + "," + price;
    }

    @Override
    public String toString()
    {
        return "[" + this.getClass().getSimpleName() + "] " + show.getMovieTitle() + " Siedzenie: " + seat.getRow() + "-" + seat.getNumber() + " | Cena: " + price;
    }
}
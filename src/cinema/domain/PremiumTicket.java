package cinema.domain;

import cinema.util.Ticket;
import java.math.BigDecimal;

public class PremiumTicket extends Ticket
{
    public PremiumTicket(Show show, Seat seat, BigDecimal price)
    {
        super(show, seat, price);
    }

    @Override
    public String toString()
    {
        return super.toString() + " (Bilet Premium)";
    }
}
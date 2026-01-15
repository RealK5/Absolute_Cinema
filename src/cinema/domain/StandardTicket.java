package cinema.domain;

import cinema.util.Ticket;
import java.math.BigDecimal;

public class StandardTicket extends Ticket
{
    public StandardTicket(Show show, Seat seat, BigDecimal price)
    {
        super(show, seat, price);
    }
}
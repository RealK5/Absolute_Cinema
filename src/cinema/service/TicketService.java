package cinema.service;

import cinema.domain.Seat;

public class TicketService
{

    public void reserveSeat(Seat seat)
    {
        if (seat == null)
        {
            throw new IllegalArgumentException("Nie ma miejsca");
        }

        if (!seat.isAvailable())
        {
            throw new IllegalStateException("Siedzenie " + seat.getRow() + "-" + seat.getNumber() + " jest już zarezerwowane.");
        }

        seat.book();
        // Dodać logikę tworzenia biletu lub zapisu transakcji.
    }

    public void cancelReservation(Seat seat) {

        if (seat == null)
        {
            throw new IllegalArgumentException("Nie ma miejsca");
        }

        seat.cancel();
    }

    public boolean isSeatAvailable(Seat seat)
    {
        if (seat == null)
        {
            return false;
        }
        return seat.isAvailable();
    }
}
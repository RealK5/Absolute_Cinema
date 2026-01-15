package cinema.service;

import cinema.domain.Seat;
import cinema.domain.Show;
import cinema.domain.StandardTicket;
import cinema.domain.PremiumTicket;
import cinema.util.Ticket;
import java.math.BigDecimal;

//Praktycznie całkowity remake by zrobić to zgodne z poleceniem 9, dalej nie wiem czy to jest dobrze

public class TicketService
{

    // ustawiamy standardową strategię cenową
    private PricingStrategy pricingStrategy = new PricingStrategy()
    {
        @Override
        public BigDecimal calculatePrice(Show show, Seat seat)
        {
            return new BigDecimal("25.00");
        }
    };

    // Setter pozwalający zmienić strategię w razie potrzeby
    public void setPricingStrategy(PricingStrategy pricingStrategy)
    {
        this.pricingStrategy = pricingStrategy;
    }

    //Kupowanie biletu
    public Ticket buyTicket(Show show, int row, int seatNumber, boolean isPremium)
    {
        //Znajdź miejsce w liście przypisanej do seansu
        Seat seat = findSeat(show, row, seatNumber);

        if (seat == null) {
            throw new IllegalArgumentException("Miejsce nie istnieje");
        }

        //Sprawdź dostępność i zarezerwuj (Bookable)
        if (!seat.isAvailable())
        {
            throw new IllegalStateException("Miejsce zajęte");
        }
        seat.book();

        //Oblicz cenę (używając zdefiniowanej wyżej strategii)
        BigDecimal price = pricingStrategy.calculatePrice(show, seat);

        // Logika dla Premium (walnąłem 50% więcej cuz why not)
        if (isPremium)
        {
            price = price.multiply(new BigDecimal("1.5"));
            return new PremiumTicket(show, seat, price);
        }
        else
        {
            return new StandardTicket(show, seat, price);
        }
    }

    // Szukanie miejsca
    private Seat findSeat(Show show, int row, int seatNumber)
    {
        if (show.getSeats() == null) return null;

        for (Seat s : show.getSeats())
        {
            if (s.getRow() == row && s.getNumber() == seatNumber)
            {
                return s;
            }
        }
        return null;
    }

    // Anulowanie rezerwacji
    public void cancelReservation(Seat seat)
    {
        if (seat == null)
        {
            throw new IllegalArgumentException("Nie ma miejsca");
        }

        seat.cancel();
    }
}
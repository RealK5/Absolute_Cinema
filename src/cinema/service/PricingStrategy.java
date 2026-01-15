package cinema.service;

import cinema.domain.Seat;
import cinema.domain.Show;
import java.math.BigDecimal;

public interface PricingStrategy
{
    BigDecimal calculatePrice(Show show, Seat seat);
}
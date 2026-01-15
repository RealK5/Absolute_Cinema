package cinema.domain;

public class Seat implements Bookable
{
    private final int row;
    private final int number;
    private boolean available;

    public Seat(int row, int number)
    {
        if (row < 1)
        {
            throw new IllegalArgumentException("Bądź ale nie bądź negatywny (rząd)");
        }
        if (number < 1)
        {
            throw new IllegalArgumentException("Bądź ale nie bądź negatywny (siedzenie)");
        }

        this.row = row;
        this.number = number;
        this.available = true; // Domyślny status: wolne
    }

    public int getRow()
    {
        return row;
    }

    public int getNumber()
    {
        return number;
    }

    @Override
    public boolean isAvailable()
    {
        return available;
    }

    @Override
    public void book()
    {
        if (!available)
        {
            throw new IllegalStateException("Siedzenie jest już zajęte");
        }
        available = false;
    }

    @Override
    public void cancel()
    {
        available = true;
    }

    @Override
    public String toString()
    {
        return "Seat{" + "row=" + row + ", number=" + number + ", available=" + available + '}';
    }
}
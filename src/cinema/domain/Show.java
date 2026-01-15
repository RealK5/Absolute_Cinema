package cinema.domain;

import cinema.util.Auditorium;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Show
{
    private final String movieTitle;
    private final Auditorium auditorium;
    private final LocalDateTime startTime;
    private List<Seat> seats;
    //konstruktorino
    public Show(String movieTitle, Auditorium auditorium, LocalDateTime startTime)
    {
        if (movieTitle == null || movieTitle.isBlank())
        {
            throw new IllegalArgumentException("Nazwa filmu jest pusta lub null");
        }
        if (auditorium == null)
        {
            throw new IllegalArgumentException("Sala jest null");
        }
        if (startTime == null)
        {
            throw new IllegalArgumentException("Film się nie zaczyna lmao");
        }

        this.movieTitle = movieTitle;
        this.auditorium = auditorium;
        this.startTime = startTime;
        this.seats = new ArrayList<>();
    }
    //Gettery i settery
    public void setSeats(List<Seat> seats)
    {
        this.seats = seats;
    }

    public List<Seat> getSeats()
    {
        return seats;
    }

    public String getMovieTitle()
    {
        return movieTitle;
    }
    public Auditorium getAuditorium()
    {
        return auditorium;
    }
    public LocalDateTime getStartTime()
    {
        return startTime;
    }

    @Override
    public String toString()
    {
        return String.format("Seans: %s w %s (%s)", movieTitle, auditorium.getName(), startTime);
    }
}
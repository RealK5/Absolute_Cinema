package cinema.domain;

import cinema.util.Auditorium;
import java.time.LocalDateTime;

public class Show
{
    private final String movieTitle;
    private final Auditorium auditorium;
    private final LocalDateTime startTime;

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
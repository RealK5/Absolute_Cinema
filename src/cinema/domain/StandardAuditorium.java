package cinema.domain;
import cinema.util.Auditorium;

public final class StandardAuditorium extends Auditorium {
    private final int seatsPerRow;

    public StandardAuditorium(String name, int rows, int seatsPerRow) {
        super(name, rows);
        if (seatsPerRow <= 0) throw new IllegalArgumentException("seatsPerRow");
        this.seatsPerRow = seatsPerRow;
    }

    @Override public int seatsInRow(int rowNumber) {
        if (rowNumber < 1 || rowNumber > getRows()) throw new IllegalArgumentException("rowNumber");
        return seatsPerRow;
    }
}

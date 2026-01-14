package cinema.domain;
import cinema.util.Auditorium;

public final class IMAXAuditorium extends Auditorium {
    private final int baseSeatsPerRow;

    public IMAXAuditorium(String name, int rows, int baseSeatsPerRow) {
        super(name, rows);
        if (baseSeatsPerRow <= 0) throw new IllegalArgumentException("baseSeatsPerRow");
        this.baseSeatsPerRow = baseSeatsPerRow;
    }

    // W IMAX z tyłu więcej miejsc
    @Override public int seatsInRow(int rowNumber) {
        if (rowNumber < 1 || rowNumber > getRows()) throw new IllegalArgumentException("rowNumber");
        int extra = (rowNumber > getRows() / 2) ? 2 : 0;
        return baseSeatsPerRow + extra;
    }
}

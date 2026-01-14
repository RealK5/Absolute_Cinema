package cinema.util;

import java.util.Objects;

public abstract class Auditorium {
    private final String name;
    private final int rows;

    protected Auditorium(String name, int rows) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name");
        if (rows <= 0) throw new IllegalArgumentException("rows");
        this.name = name;
        this.rows = rows;
    }

    public final String getName() { return name; }
    public final int getRows() { return rows; }

    // Różne sale mogą mieć inną liczbę miejsc w rzędzie
    public abstract int seatsInRow(int rowNumber);

    @Override public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auditorium other)) return false;
        return name.equals(other.name);
    }
    @Override public final int hashCode() { return Objects.hash(name); }
}

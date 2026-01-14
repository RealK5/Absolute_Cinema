package cinema.domain;

public interface Bookable {
    void book();
    void cancel();
    boolean isAvailable();
}

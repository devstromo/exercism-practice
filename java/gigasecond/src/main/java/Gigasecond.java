import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    private static final long GIGA_SECOND = 1_000_000_000;
    private final LocalDateTime dateTime;

    public Gigasecond(LocalDate moment) {
        this.dateTime = moment.atStartOfDay()
            .plusSeconds(GIGA_SECOND);
    }

    public Gigasecond(LocalDateTime moment) {
        this.dateTime = moment.plusSeconds(GIGA_SECOND);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}

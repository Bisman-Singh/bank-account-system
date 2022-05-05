import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record Transaction(
    String type,
    double amount,
    double balanceAfter,
    String description,
    LocalDateTime timestamp
) {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Transaction(String type, double amount, double balanceAfter, String description) {
        this(type, amount, balanceAfter, description, LocalDateTime.now());
    }

    public String toFileLine() {
        return "%s|%.2f|%.2f|%s|%s".formatted(type, amount, balanceAfter, description, timestamp.format(FMT));
    }

    public static Transaction fromFileLine(String line) {
        String[] parts = line.split("\\|");
        return new Transaction(
            parts[0],
            Double.parseDouble(parts[1]),
            Double.parseDouble(parts[2]),
            parts[3],
            LocalDateTime.parse(parts[4], FMT)
        );
    }

    @Override
    public String toString() {
        return "[%s] %-10s $%10.2f  Balance: $%10.2f  %s".formatted(
            timestamp.format(FMT), type, amount, balanceAfter, description);
    }
}

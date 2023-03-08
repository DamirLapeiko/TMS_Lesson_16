package by.teachmeskills.lapeiko.homework16;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Message {
    private final User user;
    private final String message;
    private final Instant time;

    public Message(User user, String message, Instant time) {
        this.user = user;
        this.message = message;
        this.time = Instant.now();
    }

    public User getUser() {
        return user;
    }

    public Instant getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Message:" +
                "user = " + user +
                "message = " + message +
                "time = " + DateTimeFormatter.ofPattern("hh:mm")
                .withZone(ZoneId.of("Europe/Minsk")).format(time);
    }
}

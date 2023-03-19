package by.teachmeskills.lapeiko.homework17;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Message {
    private final User user;
    private final String message;
    private final Instant createdInstantTime;

    public Message(User user, String message) {
        this.user = user;
        this.message = message;
        this.createdInstantTime = Instant.now();
    }

    public User getUser() {
        return user;
    }

    public Instant getCreatedInstantTime() {
        return createdInstantTime;
    }

    @Override
    public String toString() {
        return "Message:" +
                "user = " + user +
                "message = " + message +
                "createdInstantTime = " + DateTimeFormatter.ofPattern("hh:mm")
                .withZone(ZoneId.of("Europe/Minsk")).format(createdInstantTime);
    }
}

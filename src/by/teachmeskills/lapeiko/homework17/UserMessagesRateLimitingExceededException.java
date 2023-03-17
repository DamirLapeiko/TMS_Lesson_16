package by.teachmeskills.lapeiko.homework17;

import java.time.Instant;

public class UserMessagesRateLimitingExceededException extends Exception{
    private final Instant limitedTime;

    public UserMessagesRateLimitingExceededException(Instant limitedTime){
        this.limitedTime = limitedTime;
    }

    public Instant getLimitedTime() {
        return limitedTime;
    }
}

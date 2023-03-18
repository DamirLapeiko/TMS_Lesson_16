package by.teachmeskills.lapeiko.homework17;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class ChatService {
    private final int limitOfPosts;
    private final Duration postDelay;
    private Message[] historyOfMessages;

    public ChatService(int limitOfPosts, Duration postDelay) {
        if (limitOfPosts <= 0){
            throw new IllegalArgumentException("limitOfPosts must be positive");
        }
        if (postDelay.compareTo(Duration.ZERO) <= 0){
            throw new IllegalArgumentException("postDelay must be positive");
        }
        this.limitOfPosts = limitOfPosts;
        this.postDelay = postDelay;
        historyOfMessages = new Message[0];
    }

    public Message[] getHistoryOfMessages() {
        return Arrays.copyOf(historyOfMessages, historyOfMessages.length);
    }

    public void addNewMessage(User user, String message) throws UserMessagesRateLimitingExceededException {
        Instant timeOfMessage = Instant.now();
        Instant delayTime = timeOfMessage.minus(postDelay);
        int counterMessages = 0;
        for (int i = historyOfMessages.length - 1; i >= 0; i--) {
            if (historyOfMessages[i].getCreatedInstantTime().isAfter(delayTime) &&
                    historyOfMessages[i].getUser().getNickname().equals(user.getNickname())) {
                counterMessages++;
                if (counterMessages == limitOfPosts) {
                    throw new UserMessagesRateLimitingExceededException(historyOfMessages[i].
                                    getCreatedInstantTime().plus(postDelay));
                }
            }
                if (historyOfMessages[i].getCreatedInstantTime().isBefore(delayTime)) {
                    return;
            }
        }
        saveNewMessage(new Message(user, message));
    }
    private void saveNewMessage(Message newMessage) {
        historyOfMessages = Arrays.copyOf(historyOfMessages, historyOfMessages.length + 1);
        historyOfMessages[historyOfMessages.length - 1] = newMessage;
    }
}

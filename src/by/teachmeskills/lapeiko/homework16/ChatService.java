package by.teachmeskills.lapeiko.homework16;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class ChatService {
    private final int limitOfPosts;
    private final Duration postDelay;
    private Message[] historyOfMessages;

    public ChatService(int limitOfPosts, Duration postDelay) {
        this.limitOfPosts = limitOfPosts;
        this.postDelay = postDelay;
        historyOfMessages = new Message[0];
    }

    public Message[] getHistoryOfMessages() {
        return Arrays.copyOf(historyOfMessages, historyOfMessages.length);
    }

    public boolean addNewMessage(User user, String message) {
        Instant timeOfMessage = Instant.now();
        Instant delayTime = timeOfMessage.minus(postDelay);
        int counterMessages = 0;
        for (int i = historyOfMessages.length - 1; i >= 0; i--) {
            if (historyOfMessages[i].getTime().isAfter(delayTime) &&
                    historyOfMessages[i].getUser().getNickname().equals(user.getNickname())) {
                counterMessages++;
                if (counterMessages == limitOfPosts){
                    return false;
                }
                if (historyOfMessages[i].getTime().isBefore(delayTime)){
                    break;
                }
            }
        }
        saveNewMessage(new Message(user, message, timeOfMessage));
        return true;
    }
    private void saveNewMessage(Message newMessage) {
        historyOfMessages = Arrays.copyOf(historyOfMessages, historyOfMessages.length + 1);
        historyOfMessages[historyOfMessages.length - 1] = newMessage;
    }
}

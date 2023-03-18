package by.teachmeskills.lapeiko.homework17;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Scanner;

public class Homework17 {
    private static ChatService chat;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write number of messages: ");
        int limitOfPosts = Integer.parseInt(scanner.nextLine());
        System.out.print("Write delay time in seconds: ");
        Duration delayTime = Duration.ofSeconds(Integer.parseInt(scanner.nextLine()));
        System.out.println(
                """
                        Choose task:
                        1. Enter chat
                        2. Show chat history
                        0. Exit"""
        );
        while (true) {
            System.out.print("Task number: ");
            int taskNumber = Integer.parseInt(scanner.nextLine());
            switch (taskNumber) {
                case 1 -> {
                    chat = new ChatService(limitOfPosts, delayTime);
                    int counter = 0;
                    do {
                        System.out.print("Enter nickname: ");
                        User user = new User(scanner.nextLine());
                        System.out.print("Enter message: ");
                        String message = scanner.nextLine();
                        try {
                            chat.addNewMessage(user, message);
                            System.out.println("Message added to history");
                        } catch (UserMessagesRateLimitingExceededException e) {
                            System.out.printf(
                                    "You used all tries to write a message. Wait %s minutes",
                                    Duration.between(Instant.now(), e.getLimitedTime()).toSeconds());
                        }
                        if (counter++ == 10) {
                            break;
                        }
                    } while (true);
                }
                case 2 -> {
                    System.out.println("Chat history");
                    System.out.println(Arrays.toString(chat.getHistoryOfMessages()));
                }
                case 0 -> {
                    return;
                }
                default -> System.err.println("Task doesn't exist");
            }
            System.out.println();
        }
    }
}
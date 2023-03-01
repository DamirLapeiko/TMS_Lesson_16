package Example_Inheritance_and_polymorphism;

import java.time.Instant;
import java.util.Arrays;

public class FeedPost {
    protected final User author;
    protected final String content;
    private User[] liked;
    protected final Instant createdInstant;

    public FeedPost(User author, String content) {
        this.author = author;
        this.content = content;
        this.liked = new User[0];
        this.createdInstant = Instant.now();
    }

    public void addLikeBy(User user) {
        for (int i = 0; i < liked.length; i++) {
            if (liked[i].getNickname().equals(user.getNickname())) {
                return;
            }
        }
        liked = Arrays.copyOf(liked, liked.length + 1);
        liked[liked.length - 1] = user;
    }
    public int getLikesCount(){
        return liked.length;
    }

    @Override
    public String toString() {
        return "@%s - %s\n%s\n❤️ %s".formatted(
                author.getNickname(),
                createdInstant,
                content,
                getLikesCount()
                );
    }
}

package Example_Inheritance_and_polymorphism;

public class FeedRepost extends FeedPost {

    private final FeedPost originalPost;

    public FeedRepost(User author, String content, FeedPost originalPost) {
        super(author, content);
        this.originalPost = originalPost;
    }

    @Override
    public void addLikeBy(User user) {
        super.addLikeBy(user);
        originalPost.addLikeBy(user);
    }

    @Override
    public String toString() {
        return "@%s - %s\n%s\n🔁️ Репост @%s\n%s\n❤️ %s".formatted(
                author.getNickname(),
                createdInstant,
                content,
                originalPost.author.getNickname(),
                originalPost.content,
                getLikesCount()
        );
    }
}

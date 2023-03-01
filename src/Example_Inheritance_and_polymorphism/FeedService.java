package Example_Inheritance_and_polymorphism;

import java.util.Arrays;

public class FeedService {
    private FeedPost[] posts;

    public FeedService() {
        posts = new FeedPost[0];
    }

    public FeedPost[] getAll(){
        return Arrays.copyOf(posts, posts.length);
    }
    public void post(User author, String content) {
        FeedPost post = new FeedPost(author, content);
        savePost(post);
    }

    public void repost(int originalPostIndex, User author, String content){
        validatePostsIndex(originalPostIndex);
        FeedPost originalPost = posts[originalPostIndex];
        FeedRepost repost = new FeedRepost(author, content, originalPost);
        savePost(repost);
    }

    public void like(int postIndex, User user) {
        validatePostsIndex(postIndex);
        FeedPost post = posts[postIndex];
        post.addLikeBy(user);
    }
    private void savePost(FeedPost newPost){
        posts = Arrays.copyOf(posts, posts.length + 1);
        posts[posts.length - 1] = newPost;
    }

    private void validatePostsIndex(int index){
        if (index < 0 || index >= posts.length) {
            throw new IllegalArgumentException();
        }
    }
}

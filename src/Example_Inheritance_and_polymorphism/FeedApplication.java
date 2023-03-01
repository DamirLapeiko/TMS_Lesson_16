package Example_Inheritance_and_polymorphism;

public class FeedApplication {
    public static void main(String[] args) {
        FeedService feedService = new FeedService();
        User appleUser = new User("appleru");
        User olegUser = new User("oleg");
        User pavelUser = new User("pavel");
        User igorUser = new User("igor");
        feedService.post(appleUser, """
                Мы представляем новый iPhone 17.
                Он лучше всех остальных!""");
        feedService.like(0,olegUser);
        feedService.like(0,igorUser);
        feedService.like(0,pavelUser);
        feedService.repost(0, olegUser, "Класс!");
        printAll(feedService.getAll());
    }

        public static void printAll(FeedPost[] posts) {
            for (int i = 0; i < posts.length; i++) {
                FeedPost post = posts[i];
                System.out.println(post.toString());
                System.out.println("--------");
            }
        }
    }

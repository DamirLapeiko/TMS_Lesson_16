package by.teachmeskills.lapeiko.homework17;

public class User {
    private final String nickName;

    public User(String nickname) {
        this.nickName = nickname;
    }

    public String getNickname() {
        return nickName;
    }

    @Override
    public String toString(){
        return "%s".formatted(nickName);
    }
}

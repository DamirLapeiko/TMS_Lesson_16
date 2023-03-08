package by.teachmeskills.lapeiko.homework16;

public class User {
    private final String nickName;

    public User(String nickname) {
        this.nickName = nickname;
    }

    public String getNickname() {
        return nickName;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        User user = (User) obj;
        return this.nickName.equals(user.nickName);
    }

    public String toString(){
        return "%s".formatted(nickName);
    }
}

public class User {
    private String nickname;
    private static String password ;


    public User(String nickname, String password){
        this.nickname = nickname;
        this.password = password;
    }

    public String getNickname(){
        return nickname;
    }

    public String getPassword(){
        return password;
    }
}

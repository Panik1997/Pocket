public class Pocket extends User{
    private int value;

    public Pocket(String nickname, String password, int value){
        super(nickname, password);
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}

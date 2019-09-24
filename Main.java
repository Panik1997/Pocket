import java.io.*;
import java.util.Scanner;

public class Main{

    public static int cash_ammount() {
        File file = new File("test.txt");
        BufferedReader reader = null;
        int tmp = 0;
        try {
            reader = new BufferedReader(new FileReader(file));
            String k = null;
            int val;
            k = reader.readLine();
            val = Integer.parseInt(k);
            tmp = val;

        } catch (IOException x) {
            x.printStackTrace();
        }
        return tmp;
    }

    public static void income(int x){
        try {
            int tmp;
            File file = new File("test.txt");
            FileWriter filewriter = new FileWriter(file, true);
            tmp = cash_ammount() + x;
            filewriter.write(tmp);
        } catch (IOException z){
            z.printStackTrace();
        }
    }

    public static void main(String[] args){

        User ja = new Pocket("Kuba", "qwerty", cash_ammount());
        System.out.println("Welcome to the vitual outcome controller, Kuba!");
        System.out.println("Enter your password:");
        Scanner tmp = new Scanner(System.in);
        String pw_text = tmp.nextLine();
        if(pw_text.equals(ja.getPassword())){
            System.out.println("You have successfully entered to your account!");
        } else {
            System.out.println("Wrong password!");
        }
        System.out.println("Your cash: " + ((Pocket) ja).getValue());
        income(50);
        System.out.println("Your cash: " + ((Pocket) ja).getValue());
    }
}
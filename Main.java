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
            reader.close();

        } catch (IOException x) {
            x.printStackTrace();
        }
        return tmp;

    }

    public static void income(int x) throws IOException{

        int tmp;
        tmp = cash_ammount() + x;
        File file = new File("test.txt");
        Writer filewriter = new FileWriter(file);
        filewriter.write(Integer.toString(tmp));
        filewriter.close();

    }

    public static void outcome(int x) throws  IOException{

        int tmp;
        tmp = cash_ammount() - x;
        File file = new File("test.txt");
        Writer filewriter = new FileWriter(file);
        filewriter.write(Integer.toString(tmp));
        filewriter.close();

    }

    public static void main(String[] args) throws IOException{

        User ja = new Pocket("Kuba", "qwerty", cash_ammount());
        System.out.println("Welcome to the vitual outcome controller, Kuba!");
        System.out.println("Enter your password:");
        Scanner tmp = new Scanner(System.in);
        String pw_text = tmp.nextLine();

        if(pw_text.equals(ja.getPassword())){
            System.out.println("\n________________________________________________________________");
            System.out.println("\nYou have successfully entered to your account!");
            System.out.println("\n________________________________________________________________");
        } else {
            System.out.println("Wrong password!");
        }

        int number;
        boolean check = true;
        Scanner num = new Scanner(System.in);

        while(check){

            System.out.println("\nChoose an option below:\n1. Show your pocket\n2. Income\n3. Outcome\n4. Exit\n");
            number = num.nextInt();

            switch(number){
                case 1:
                    System.out.println("\n________________________________________________________________");
                    System.out.println("Your pocket: " + ((Pocket) ja).getValue());
                    System.out.println("________________________________________________________________");
                    break;
                case 2:
                    Scanner scan1 = new Scanner(System.in);
                    System.out.println("\n________________________________________________________________");
                    System.out.println("Value of income: ");
                    int income_value = scan1.nextInt();
                    System.out.println("\n________________________________________________________________");
                    System.out.println("\n\n\n");
                    income(income_value);
                    ((Pocket) ja).setValue(cash_ammount());
                    break;
                case 3:
                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("\n________________________________________________________________");
                    System.out.println("Value of outcome: ");
                    int outcome_value = scan2.nextInt();
                    System.out.println("\n________________________________________________________________");
                    System.out.println("\n\n\n");
                    outcome(outcome_value);
                    ((Pocket) ja).setValue(cash_ammount());
                    break;
                case 4:
                    check = false;
                    break;

            }

        }

    }

}
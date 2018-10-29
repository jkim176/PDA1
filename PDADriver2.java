import java.util.ArrayList;
import java.util.Scanner;

public class PDADriver2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean restart = true;
        String restartString;

        while (restart) {
            System.out.println("Enter a string;");
            String userString = input.next();       // user string

            PDA1 pda = new PDA1();

            if (userString.length() == 0) {
                pda.addSequence("Q1");
                pda.printSequence();
                ArrayList<String> sequence = pda.getSequence();
                // do animation with sequence
                System.out.println(userString + " is accepted.");
            }
            else if(userString.charAt(0) == '0' && userString.length() > 1) {      // if first char is 0 and length > 1
                int i = 0;
                while(i < userString.length() && userString.charAt(i) == '0') {
                    pda.addSequence("Q0");
                    pda.push('X');
                    i++;

                }
                while(i < userString.length() && userString.charAt(i) == '1') {
                    pda.addSequence("Q1");
                    pda.pop();
                    i++;

                }
                if(pda.isEmpty() && i == userString.length()) {
                    System.out.println(userString + " is accepted.");
                }
                else {
                    System.out.println(userString + " is rejected.");
                }
            }
            else {
                if(userString.charAt(0) == '0')
                    pda.addSequence("Q0");
                else if(userString.charAt(0) == '1')
                    pda.addSequence("Q1");
                System.out.println(userString + " is rejected.");
            }
            System.out.print("Sequence: ");
            pda.printSequence();
            // do animation with sequence
            ArrayList<String> sequence = pda.getSequence();

            System.out.println("To restart this program, enter any key.  Enter 0 to quit.");
            restartString = input.next();
            if(restartString.length() == 1 && restartString.charAt(0) == '0')
                restart = false;
        }
    }
}

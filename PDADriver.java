import java.util.Scanner;
import java.util.ArrayList;

public class PDADriver {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean restart = true;
        String restartString;

        while (restart) {
            System.out.println("Enter a string;");
            String userString = input.next();       // user string

            PDA1 pda = new PDA1();

            if (userString.length() == 0 || userString.length() == 1) {      // userString length <= 1
                pda.addSequence("Q1");
                pda.printSequence();
                ArrayList<String> sequence = pda.getSequence();
                // do animation with sequence
                System.out.println(userString + " is accepted.");
            } else {                                                          // userString length >= 2 /////////////////////
                int halfway = userString.length() / 2;
                pda.addSequence("Q0");

                for (int i = 0; i < halfway; i++) {      // 0 to half
                    pda.push(userString.charAt(i));     // animate
                    pda.addSequence("Q0");
                }

                if (userString.length() % 2 == 1) {      // if user string is odd /////////////////////////////
                    pda.addSequence("Q1");      // middle char

                    for (int i = halfway + 1; i < userString.length(); i++) {        // half to end
                        if (pda.peek() == userString.charAt(i)) {        // match top of stack to char -to be popped-
                            pda.pop();      // animate
                            pda.addSequence("Q1");
                        }
                    }
                    if (pda.isEmpty()) {         // finished verifying all char in userString, check for empty stack
                        System.out.println(userString + " is accepted.");
                    } else {
                        System.out.println(userString + " is rejected.");
                    }
                } else {                                  // if user string is even ////////////////////////////
                    for (int i = halfway; i < userString.length(); i++) {        // half to end
                        if (pda.peek() == userString.charAt(i)) {        // match top of stack to char -to be popped-
                            pda.pop();      // animate
                            pda.addSequence("Q1");
                        }
                    }
                    if (pda.isEmpty()) {         // finished verifying all char in userString, check for empty stack
                        System.out.println(userString + " is accepted.");
                    } else {
                        System.out.println(userString + " is rejected.");
                    }
                }
            }
            System.out.print("Sequence: ");
            pda.printSequence();

            System.out.println("To restart this program, enter any key.  Enter 0 to quit.");
            restartString = input.next();
            if(restartString.length() == 1 && restartString.charAt(0) == '0')
                restart = false;
        }
    }
}

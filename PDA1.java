import java.util.Stack;
import java.util.ArrayList;

public class PDA1 {

    private Stack<Character> stack = new Stack<>();
    private ArrayList<String> sequence = new ArrayList<>();

    void addSequence(String state) {
        sequence.add(state);
    }

    void push(char character) {
        stack.push(character);
    }

    char peek() {
        return stack.peek();
    }

    void pop() {
        stack.pop();
    }

    boolean isEmpty() {
        return stack.isEmpty();
    }

    ArrayList<String> getSequence() {
        return sequence;
    }

    void printSequence() {
        for(String s: sequence) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}

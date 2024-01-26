import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(int i=0; i<input.length; i++){
            switch(input[i]){
                case '(':
                    stack.push(input[i]);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek()!='(')
                        result.append(stack.pop());
                    stack.pop();
                    break;
                case '*':
                case '/':
                    while(!stack.isEmpty() && (stack.peek()=='*' || stack.peek()=='/'))
                        result.append(stack.pop());
                    stack.push(input[i]);
                    break;
                case '+':
                case '-':
                    while(!stack.isEmpty() && stack.peek()!='(')
                        result.append(stack.pop());
                    stack.push(input[i]);
                    break;
                default:
                    result.append(input[i]);
                    break;
            }
        }

        while(!stack.isEmpty()) result.append(stack.pop());
        System.out.println(result);
    }

}
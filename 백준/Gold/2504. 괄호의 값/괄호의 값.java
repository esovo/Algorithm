import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int answer = 0, temp = 1;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '('){
                temp *= 2;
                stack.push(arr[i]);
            }
            else if(arr[i] == '['){
                temp *= 3;
                stack.push(arr[i]);
            }
            else{
                if(stack.isEmpty()){
                    answer = 0;
                    break;
                }
                char ch = stack.peek();
                if(arr[i]==')' && ch=='('){
                    if(arr[i-1] == '(') answer += temp;
                    temp /= 2;
                }
                else if(arr[i]==']' && ch=='['){
                    if(arr[i-1] == '[') answer += temp;
                    temp /= 3;
                }
                else break;
                stack.pop();
            }
        }

        System.out.println(stack.isEmpty() ? answer : 0);
    }

}
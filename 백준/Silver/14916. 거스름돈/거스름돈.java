import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        while(n > 0){
            if(n%5 == 0){
                answer += n/5;
                n %= 5;
            }
            else{
                n -= 2;
                answer++;
            }
        }
        System.out.println(n!=0 ? -1 : answer);
    }

}
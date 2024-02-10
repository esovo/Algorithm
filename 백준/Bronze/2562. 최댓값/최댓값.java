import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int idx = 0;
        for(int i=1; i<=9; i++){
            int num = Integer.parseInt(br.readLine());
            if(max < num){
                idx = i;
                max = num;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    
    static Map<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        map.put(0L, 0L);
        map.put(1L, 1L);
        System.out.println(fibo(N));
    }

    private static long fibo(long n){
        if (!map.containsKey(n)){
            if (n%2 == 1) {
                long a = fibo(n/2);
                long b = fibo(n/2+1);
                map.put(n, (a*a+b*b)%1000000007);
            }
            else{
                long a = fibo(n/2);
                long b = fibo(n/2-1);
                map.put(n, (a*(a+2*b))%1000000007);
            }
        }
        return map.get(n);
    }

}
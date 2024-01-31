import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][2*N-1];
        for(int i=0; i<N; i++) Arrays.fill(arr[i], ' ');

        draw(0, N-1, N);
        for(int i=0; i<N; i++) {
            for(int j=0; j<2*N-1; j++) sb.append(arr[i][j]);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void draw(int x, int y, int num){
        if (num == 3) {
            arr[x][y] = '*';
            arr[x+1][y-1] = arr[x+1][y+1] = '*';
            arr[x+2][y-2] = arr[x+2][y-1] = arr[x+2][y] = arr[x+2][y+1] = arr[x+2][y+2] = '*';
            return;
        }

        // 재귀 호출: 크기가 3 이상인 경우 분할하여 재귀 호출
        int next = num/2;
        draw(x, y, next);
        draw(x+next, y-next, next);
        draw(x+next, y+next, next);
    }

}
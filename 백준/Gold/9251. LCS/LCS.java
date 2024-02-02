import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] strA = br.readLine().toCharArray();
        char[] strB = br.readLine().toCharArray();
        int[][] LCS = new int[strA.length+1][strB.length+1];

        for(int i=0; i<strA.length+1; i++){
            for(int j=0; j<strB.length+1; j++){
                if(i==0 || j==0) LCS[i][j]=0;
                else{
                    LCS[i][j] = LCS[i-1][j];
                    if(strA[i-1] == strB[j-1]) LCS[i][j] = LCS[i-1][j-1]+1;
                    else LCS[i][j] = Math.max(LCS[i][j], LCS[i][j-1]);
                }
            }
        }
        System.out.println(LCS[strA.length][strB.length]);
    }

}
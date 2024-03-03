import java.util.*;

class Solution {
    
    int N;
    int[][] copyDice;
    boolean[] selected;
    List<int[]> diceCombA, diceCombB;
    public int[] solution(int[][] dice) {
        // 1. 주사위 조합 구하기
        N = dice.length;
        selected = new boolean[N];
        diceCombA = new ArrayList<>();
        diceCombB = new ArrayList<>();
        comb(0, 0);
        
        // 2. 각 주사위 조합 별 나올 수 있는 합 구하기
        copyDice = dice;
        int maxWin = -1;
        int maxIdx = -1;
        for(int i=0; i<diceCombA.size(); i++){
            int[] resultA = new int[N/2*100+1];
            int[] resultB = new int[N/2*100+1];
            roll(resultA, diceCombA.get(i), 0, 0);
            roll(resultB, diceCombB.get(i), 0, 0);
            // B 주사위 조합에서 나올 수 있는 합에 대한 누적합
            for(int j=1; j<resultB.length; j++) resultB[j] += resultB[j-1];
            
            // 3. 승리 확률 계산
            int wins = 0;
            for(int j=2; j<resultA.length; j++)
                wins += resultA[j]*resultB[j-1];
            if (wins > maxWin){
                maxWin = wins;
                maxIdx = i;
            }
        }
        
        int[] answer = diceCombA.get(maxIdx);
        for(int i=0; i<N/2; i++) answer[i]++;
        return answer;
    }
    
    private void roll(int[] result, int[] dices, int cnt, int sum){
        if(cnt == N/2) {
            result[sum]++;
            return;
        }
        
        int[] current = copyDice[dices[cnt]];
        for(int i=0; i<6; i++){
            roll(result, dices, cnt+1, sum+current[i]);
        }
    }
    
    private void comb(int cnt, int start){
        if(cnt==N/2){
            int idxA = 0, idxB = 0;
            int[] A = new int[N/2];
            int[] B = new int[N/2];
            for(int i=0; i<N; i++){
                if(selected[i]) A[idxA++] = i;
                else B[idxB++] = i;
            }
            diceCombA.add(A);
            diceCombB.add(B);
            return;
        }
        for(int i=start; i<N; i++){
            if(selected[i]) continue;
            selected[i] = true;
            comb(cnt+1, i+1);
            selected[i] = false;
        }
    }
    
}
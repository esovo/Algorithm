import java.util.*;

class Solution {
    
    public int solution(int[][] scores) {
        int[] wan = scores[0];
        int answer = 1, max = 0, sum = wan[0]+wan[1];
        Arrays.sort(scores, (a, b) -> a[0]==b[0] ? a[1]-b[1] : b[0]-a[0]);

        for(int[] score : scores){
            if(score[1] >= max){
                max = Math.max(max, score[1]);
                if(score[0]+score[1] > sum) answer++; // 완호보다 합이 큰 경우
                continue;
            }
            if(score.equals(wan)) return -1;
        }
        return answer;
    }
    
}
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) map.put(friends[i], i);
        
        StringTokenizer st;
        int[][] counts = new int[n][n];
        int[][] scores = new int[n][2];
        for(int i=0; i<gifts.length; i++){
            st = new StringTokenizer(gifts[i]);
            int giver = map.get(st.nextToken());
            int receiver = map.get(st.nextToken());
            counts[giver][receiver]++;
            scores[giver][0]++;
            scores[receiver][1]++;
        }
        
        int[] answer = new int[n];
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(counts[i][j] > counts[j][i]) answer[i]++;
                else if(counts[i][j] == counts[j][i]){
                    int scoreA = scores[i][0]-scores[i][1];
                    int scoreB = scores[j][0]-scores[j][1];
                    if(scoreA > scoreB) answer[i]++;
                    else if(scoreA < scoreB) answer[j]++;
                }
                else answer[j]++;
            }    
        }
        
        Arrays.sort(answer);
        return answer[n-1];
    }
}
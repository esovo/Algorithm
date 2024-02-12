import java.util.*;

class Solution {
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        HashMap<Integer, int[]> map = new HashMap<>();
        
        for(int[] edge : edges){
            if (!map.containsKey(edge[0])) map.put(edge[0], new int[]{0, 0});
            if (!map.containsKey(edge[1])) map.put(edge[1], new int[]{0, 0});
            map.get(edge[0])[1]++;
            map.get(edge[1])[0]++;
        }
        
        for(int i=1; i<=map.size(); i++){
            if(!map.containsKey(i)) continue;
            // 생성한 정점 찾기
            if(map.get(i)[0]==0 && map.get(i)[1]>=2) answer[0] = i;
            // 막대 그래프
            else if(map.get(i)[1]==0) answer[2]++;
            // 8자 그래프
            else if(map.get(i)[0]>=2 && map.get(i)[1]==2) answer[3]++;
        }
        // 도넛 그래프
        answer[1] = map.get(answer[0])[1] - (answer[2]+answer[3]);
        return answer;
    }
    
}
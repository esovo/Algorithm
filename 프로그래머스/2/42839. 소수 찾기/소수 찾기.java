import java.util.*;

class Solution {
    
    static int n;
    static char[] nums;
    static Set<Integer> set;
    static boolean[] visited;
    public int solution(String numbers) {
        n = numbers.length();
        nums = numbers.toCharArray();
        visited = new boolean[n];
        set = new HashSet<>();
        for(int i=1; i<=n; i++) perm(0, i, "");
        return set.size();
    }
    
    private void perm(int cnt, int r, String str){
        if(cnt==r){
            int num = Integer.parseInt(str);
            if(num<=1 || set.contains(num)) return;
            // 소수 찾기
            for(int i=2; i<num; i++){
                if(num%i == 0) return;
            }
            set.add(num);
            return;    
        }
        
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            perm(cnt+1, r, str+nums[i]);
            visited[i] = false;
        }
    }
    
}
import java.util.*;

class Solution {
    
    public String solution(int n, int t, int m, int p) {
        List<String> list = new ArrayList<>();
        for(int i=0; i<p+(t-1)*m; i++){
            String[] tmp = Integer.toString(i, n).toUpperCase().split("");
            for(String s : tmp) list.add(s);
        }
        
        // 튜브가 말해야하는 수 담기
        StringBuilder ans = new StringBuilder();
        for(int i=p-1; i<p+(t-1)*m; i+=m) ans.append(list.get(i));
        return ans.toString();
    }
    
}
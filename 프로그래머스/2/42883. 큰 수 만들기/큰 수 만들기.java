import java.util.*;

class Solution {
    
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<number.length(); i++){
            if(st.isEmpty()) {
                st.push(number.charAt(i));
                continue;
            }

            if(k > 0){
                while(st.peek() < number.charAt(i)){
                    st.pop();
                    k--;
                    if(st.isEmpty() || k==0) break;
                }    
            }
            
            st.push(number.charAt(i));
        }
        
        while(!st.isEmpty()) sb.append(st.pop());
        
        return k>0 ? number.substring(0, number.length()-k) : sb.reverse().toString();
    }
    
}
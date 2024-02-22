import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {        
        // 1. 카드 n/3장 뽑기
        int idx = 0;
        int N = cards.length;
        HashMap<Integer, Integer> init = new HashMap<>();
        for(idx=0; idx<N/3; idx++) init.put(cards[idx], (N+1)-cards[idx]);
        
        // 2. 게임
        int answer = 1;
        if(coin == 0){
            boolean isContinue = true;
            outer: while(isContinue){
                Set<Integer> keySet = init.keySet();
                for(int key : keySet){
                    int value = init.get(key);
                    if(init.containsKey(value)){
                        init.remove(key);
                        init.remove(value);
                        answer++;
                        System.out.println(key + " " + value);
                        continue outer;
                    }
                }   
                isContinue = false;
            }
        }
        else{
            HashMap<Integer, Integer> extra = new HashMap<>();
            outer: while(coin > 0){
                Set<Integer> keySet = init.keySet();
                for(int i=0; i<2; i++){
                    if(idx >= N) break;
                    extra.put(cards[idx], (N+1)-cards[idx]);
                    idx++;
                }
                for(int key : keySet){
                    int value = init.get(key);
                    if(init.containsKey(value)){
                        init.remove(key);
                        init.remove(value);
                        answer++;
                        continue outer;
                    } 
                }

                for(int key : keySet){
                    int value = init.get(key);
                    if(extra.containsKey(value)){
                        init.remove(key);
                        extra.remove(value);
                        answer++;
                        coin--;
                        continue outer;
                    }
                }

                if(coin >= 2){
                    Set<Integer> extraSet = extra.keySet();
                    for(int key : extraSet){
                        int value = extra.get(key);
                        if(extra.containsKey(value)){
                            extra.remove(key);
                            extra.remove(value);
                            answer++;
                            coin -= 2;
                            continue outer;
                        } 
                    }
                }
                break;
            }
        }
        
        System.out.println((N-N/3)/2+1);
        return answer > (N-N/3)/2+1 ? (N-N/3)/2+1 : answer;
    }
}
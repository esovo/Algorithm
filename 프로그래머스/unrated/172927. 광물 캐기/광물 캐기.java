import java.util.*;

class Solution {
    
    /*
        1. 곡괭이는 종류 상관 없이 5개 캐면 파괴
        2. 다이아는 모든 종류 +1, 철은 다이아 +5 / 이외 +1, 돌은 다이아 +25 / 철 +5 / 돌 +1
        3. 광물 캐는 순서는 정해져 있음
        4. 최소한의 피로도 return
    */
    
    class Mineral implements Comparable<Mineral>{
        int order, dia, iro, sto;
        
        public Mineral(int order, int dia, int iro, int sto){
            this.order = order;
            this.dia = dia;
            this.iro = iro;
            this.sto = sto;
        }
        
        public int compareTo(Mineral m){
            if(this.dia == m.dia){
                if(this.iro == m.iro)
                    return m.sto-this.sto;
                return m.iro-this.iro;
            }
            return m.dia-this.dia;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        List<Mineral> list = new ArrayList<>();
        
        int order=1, dia=0, iro=0, sto=0;
        for(int i=0; i<minerals.length; i++){
            if(i!=0 && i%5==0){
                list.add(new Mineral(order++, dia, iro, sto));
                dia=0; iro=0; sto=0;
            }
            
            if(minerals[i].equals("diamond")) dia++;
            else if(minerals[i].equals("iron")) iro++;
            else sto++;
        }
        
        if(dia!=0 || iro!=0 || sto!=0) list.add(new Mineral(order, dia, iro, sto));
        
        Collections.sort(list);

        int pick = picks[0]+picks[1]+picks[2];
        int answer = 0;
        while(true){
            if(picks[0]==0 && picks[1]==0 && picks[2]==0) break;
            if(list.size()==0) break;
            
            Mineral m = list.get(0);
            if(m.order <= pick){
                if(picks[0] > 0){
                    answer += m.dia + m.iro + m.sto;
                    picks[0]--;
                }
                else if(picks[1] > 0){
                    answer += m.dia*5 + m.iro + m.sto;
                    picks[1]--;
                }
                else{
                    answer += m.dia*25 + m.iro*5 + m.sto;
                    picks[2]--;
                }
            }
            list.remove(0);
        }
        
        return answer;
    }
    
}
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Arrays;

class Solution {
    class Plan implements Comparable<Plan>{
        String name;
        Integer start, playtime;
        
        public Plan(String name, Integer start, Integer playtime){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
        
        public int compareTo(Plan plan){
            return this.start - plan.start;
        }
    }
    
    public String[] solution(String[][] plans) {
        Plan[] array = new Plan[plans.length];
        List<String> list = new ArrayList<>();
        Stack<Plan> stack = new Stack<>();
        
        // 1. 시작 시각, 종료 시각 처리
        // 00:00 :앞의 2숫자 * 60 + 뒷 숫자로 처리
        for(int i=0; i<plans.length; i++){
            StringTokenizer st = new StringTokenizer(plans[i][1], ":");
            int start_time = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            array[i] = new Plan(plans[i][0], start_time, Integer.parseInt(plans[i][2]));
        }
        
        // 2. 시작 시각에 따라 오름차순 정렬
        Arrays.sort(array);
        
        // 3. 시작 시각, 종료 시각에 따라 스택에 삽입 및 삭제
        for(int i=0; i<array.length-1; i++){
            int cur = array[i].start + array[i].playtime;
            int next = array[i+1].start;
            
            // 다음 과제의 시작시각이 진행중인 과제의 종료시각보다 빠른 경우
            if(cur > next){
                // 차이만큼 수행 시간 차감한 다음 현재 진행중인 과제를 스택에 담기
                array[i].playtime -= (array[i].playtime - (cur-next));
                stack.push(array[i]);
            }
            // 다음 과제의 시작시각이 진행중인 과제의 종료시각과 같은 경우 현재 진행중인 과제 리스트에 담기
            else if(cur == next) list.add(array[i].name);
            else{ // 다음 과제의 시작 시각이 진행중인 과제의 종료시각과 같거나 느린 경우
                list.add(array[i].name);
                int temp = next-cur;
                // 진행중인 과제와 다음 과제 사이에 시간이 남는 경우 남는 시간동안 밀린 과제 처리하기
                // 여유 시간이 있고 밀린 과제가 있는 경우 반복
                while(temp > 0 && !stack.isEmpty()){
                    int time = stack.peek().playtime;
                    // 여유 시간 > 밀린 과제 시간 -> 밀린 과제 리스트에 담고 삭제
                    if(temp >= time){
                        list.add(stack.pop().name);
                        temp -= time;
                    }
                    else {
                        Plan plan = stack.pop();
                        plan.playtime -= temp;
                        stack.push(plan);
                        temp = 0;
                    }
                }
            }
        }
        
        list.add(array[array.length-1].name);
        
        while(!stack.isEmpty()){
            list.add(stack.pop().name);
        }
        
        // 4. 리스트를 배열로 변환하여 반환
        String answer[] = list.toArray(new String[list.size()]);
        return answer;
    }
}
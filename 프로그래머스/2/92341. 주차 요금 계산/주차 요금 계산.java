import java.util.*;

class Solution {
    
    static class Car implements Comparable<Car>{
        int num, time, sum;
        
        public Car(int num, int time, int sum){
            this.num = num;
            this.time = time;
            this.sum = sum;
        }
        
        public void setTime(int time){
            this.time = time;
        }
        
        public void setSum(int sum){
            this.sum = sum;
        }
        
        public int compareTo(Car c){
            return this.num - c.num;
        }
            
        public boolean equals(Object o){
            Car car = (Car)o;
            return this.num==car.num;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        
        List<Car> list = new ArrayList<>();
        boolean[] isIn = new boolean[10000];
        
        for(int i=0; i<records.length; i++){
            StringTokenizer st = new StringTokenizer(records[i]);
            int time = change(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
            
            int idx = list.indexOf(new Car(num, time, 0));
            Car car = idx==-1 ? null : list.get(idx);
            
            if(type.equals("IN")){
                if(car != null) car.setTime(time);
                else list.add(new Car(num, time, 0));
                isIn[num] = true;
            }
            else{
                car.setSum(car.sum+(time-car.time));
                isIn[num] = false;
            }
        }
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            if(isIn[list.get(i).num]) list.get(i).sum += (23*60 + 59 - list.get(i).time);
            int cost = fees[1];
            int sum = list.get(i).sum;
            if(sum > fees[0]){
                sum -= fees[0];
                cost += (fees[3] * Math.ceil((double)sum / fees[2]));
            }
            answer[i] = cost;
        }
        return answer;
    }
    
    private int change(String time){
        StringTokenizer st = new StringTokenizer(time, ":");
        return Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
    }
    
}
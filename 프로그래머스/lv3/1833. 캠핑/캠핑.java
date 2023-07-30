import java.util.*;

class Solution {
    
    static class Point implements Comparable<Point>{
        int x, y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public int compareTo(Point p){
            if(this.x==p.x) return this.y - p.y;
            return this.x - p.x;
        }
    }
    
    public int solution(int n, int[][] data) {
        
        Point[] arr = new Point[n];
        for(int i=0; i<n; i++){
            arr[i] = new Point(data[i][0], data[i][1]);
        }
        Arrays.sort(arr);
        
        int answer = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                // 직사각형의 넓이가 0인 경우
                if(arr[i].x==arr[j].x || arr[i].y==arr[j].y) continue;
                
                // 직사각형 내부에 쐐기가 있는 경우
                boolean isIn = false;
                for(int idx=i+1; idx<j; idx++){
                    int x1 = Math.min(arr[i].x, arr[j].x);
                    int x2 = Math.max(arr[i].x, arr[j].x);
                    int y1 = Math.min(arr[i].y, arr[j].y);
                    int y2 = Math.max(arr[i].y, arr[j].y);
                    if(x1<arr[idx].x && arr[idx].x<x2 && y1<arr[idx].y && arr[idx].y<y2){
                        isIn = true;
                        break;
                    }
                }
                
                if(!isIn) answer++;
            }
        }
        
        return answer;
        
    }
    
}
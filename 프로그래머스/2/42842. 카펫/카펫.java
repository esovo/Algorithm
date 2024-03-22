class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        brown = (brown-4)/2; // x+y
        for(int x=yellow; x>=1; x--){
            if(yellow%x!=0) continue;
            int y = yellow/x;
            if(x<y) continue;
            if(x*y==yellow && x+y==brown){
                answer[0] = x+2;
                answer[1] = y+2;
                break;
            }
        }
        return answer;
    }
}
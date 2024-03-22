class Solution {
    public int[] solution(int[] answers) {
        int[] supo1 = {1, 2, 3, 4, 5};
        int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] count = new int[3];
        int max = 0, cnt = 0;
        for(int i=0; i<answers.length; i++){
            if(answers[i] == supo1[i%supo1.length]) count[0]++;
            if(answers[i] == supo2[i%supo2.length]) count[1]++;
            if(answers[i] == supo3[i%supo3.length]) count[2]++;
            if(i==answers.length-1){
                max = Math.max(max, Math.max(count[0], Math.max(count[1], count[2])));
                for(int j=0; j<3; j++){
                    if(count[j] == max) cnt++;
                }
            }
        }
        
        int idx = 0;
        int[] answer = new int[cnt];
        for(int i=0; i<3; i++){
            if(count[i]==max) answer[idx++] = i+1; 
        }
        return answer;
    }
}
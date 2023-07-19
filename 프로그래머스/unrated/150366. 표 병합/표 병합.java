import java.util.*;
import java.awt.Point;

class Solution {
    
    public String[] solution(String[] commands) {
        
        List<String> list = new ArrayList<>();
        String[][] table = new String[51][51];
        Point[][] merge = new Point[51][51];
        
        for(int i=1; i<51; i++){
            for(int j=1; j<51; j++)
                merge[i][j] = new Point(i, j);
        }
        
        for(int i=0; i<commands.length; i++){
            StringTokenizer st = new StringTokenizer(commands[i]);
            String command = st.nextToken();
            
            if(command.equals("UPDATE")){
                if(st.countTokens() == 3){ // 숫자인 경우
                    int r = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    String value = st.nextToken();
                    table[merge[r][c].x][merge[r][c].y] = value;
                }
                else{ // 문자열인 경우
                    String value1 = st.nextToken();
                    String value2 = st.nextToken();
                    for(int r=1; r<51; r++){
                        for(int c=1; c<51; c++){
                            if(table[r][c]!=null && table[r][c].equals(value1)) table[r][c] = value2;
                        }
                    }
                }
            }
            else if(command.equals("MERGE")){
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
               
                int newR1 = merge[r1][c1].x;
                int newC1 = merge[r1][c1].y;
                int newR2 = merge[r2][c2].x;
                int newC2 = merge[r2][c2].y;
                
                for(int j=1; j<51; j++){
                    for(int k=1; k<51; k++){
                        if(merge[j][k].x==newR2 && merge[j][k].y==newC2)
                            merge[j][k] = new Point(newR1, newC1);
                    }
                }
                
                if(newR1 == newR2 && newC1 == newC2) continue;
                if(table[newR1][newC1] != null && table[newR2][newC2] == null) table[newR2][newC2] = table[newR1][newC1];
                else if(table[newR1][newC1] == null && table[newR2][newC2] != null) table[newR1][newC1] = table[newR2][newC2];
                else if(table[newR1][newC1] != null && table[newR2][newC2] != null) table[newR2][newC2] = table[newR1][newC1];
            }
            else if(command.equals("UNMERGE")){
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                
                int newR = merge[r][c].x;
                int newC = merge[r][c].y;
                String value = table[newR][newC];

                for(int j=1; j<51; j++){
                    for(int k=1; k<51; k++){
                        if(merge[j][k].x == newR && merge[j][k].y == newC){
                            merge[j][k] = new Point(j,k);
                            table[j][k] = null;
                        }
                    }
                }
                table[r][c] = value;
            }
            else{ // PRINT
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                String value = table[merge[r][c].x][merge[r][c].y];
                list.add(value == null ? "EMPTY" : value);
            }
        }
        
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
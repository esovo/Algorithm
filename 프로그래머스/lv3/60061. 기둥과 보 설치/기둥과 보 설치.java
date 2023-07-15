import java.util.*;

class Solution {
    ArrayList<Build> ret = new ArrayList<>();
    
    public int[][] solution(int n, int[][] build_frame) {
        for (int[] arr : build_frame) {
            Build s = get(arr[0], arr[1], arr[2]);
            // 설치
            if (arr[3] == 1) {
                ret.add(s);
                // 설치 안되면 다시 지움
                if (check())
                    ret.remove(s);
            } else {
                ret.remove(s);
                // 삭제 안되면 다시 넣음
                if (check())
                    ret.add(s);
            }
        }
        // 출력 형태 맞추기
        
        int[][] answer = new int[ret.size()][3];
        int i = 0;
        Collections.sort(ret);
        for(Build b : ret)
            answer[i++] = new int[]{b.x, b.y, b.a};
        
        return answer;
    }

    boolean check() {
        for(Build b : ret) {
            int x = b.x, y = b.y, a = b.a;
            // 기둥일 때
            // 밑에 바닥이거나, 기둥이거나, 보의 끝일 때
            if(a == 0) {
                if(y != 0 &&
                        !ret.contains(get(x, y - 1, 0)) &&
                        !ret.contains(get(x - 1, y, 1)) &&
                        !ret.contains(get(x, y, 1))) return true;
            } else {
                // 한 쪽이 기둥이거나, 양쪽 끝이 보일 때
                if(!ret.contains(get(x, y - 1, 0)) &&
                        !ret.contains(get(x + 1, y - 1, 0)) &&
                        !(ret.contains(get(x - 1, y, 1)) && ret.contains(get(x + 1, y, 1))))
                    return true;
            }
        }
        return false;
    }

    Build get(int x, int y, int a) {
        return new Build(x, y, a);
    }
    
        static class Build implements Comparable<Build>{
        int x, y, a;
        
        Build(int x, int y, int a) {
            this.x = x;
            this.y = y;
            this.a = a;
        }

        @Override
        public int compareTo(Build o) {
           	if(this.x != o.x) return this.x - o.x;
            if(this.y != o.y) return this.y - o.y;
            return this.a - o.a;
        }

        @Override
        public boolean equals(Object o) {
            Build build = (Build) o;
            return x == build.x && y == build.y && a == build.a;
        }
    }
}
import java.util.*;

class Solution {
    
    class Music implements Comparable<Music> {
        int num, play;

        Music(int num, int play) {
            this.num = num;
            this.play = play;
        }

        @Override
        public int compareTo(Music m) {
            if (this.play == m.play) return this.num - m.num;
            return m.play - this.play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Music>> genresMap = new HashMap<>();
        int idx = 0;

        // 각 장르별 분류
        for (int i = 0; i < genres.length; i++) {
            Music m = new Music(i, plays[i]);
            if (!genresMap.containsKey(genres[i])) {
                genresMap.put(genres[i], new ArrayList<>());
            }
            genresMap.get(genres[i]).add(m);
        }

        // 장르 내림차순
        List<String> sortedGenres = new ArrayList<>(genresMap.keySet());
        sortedGenres.sort((g1, g2) -> {
            int play1 = genresMap.get(g1).stream().mapToInt(music -> music.play).sum();
            int play2 = genresMap.get(g2).stream().mapToInt(music -> music.play).sum();
            return play2 - play1;
        });

        // 베스트 앨범에 추가할 노래 목록
        List<Integer> list = new ArrayList<>();

        // 각 장르에서 최대 2개의 Music를 선택하여 베스트 앨범에 추가
        for (String genre : sortedGenres) {
            List<Music> musicList = genresMap.get(genre);
            musicList.sort(Music::compareTo);
            int count = 0;
            for (Music music : musicList) {
                list.add(music.num);
                count++;
                if (count >= 2) {
                    break;
                }
            }
        }

        // 결과 배열 초기화
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
}
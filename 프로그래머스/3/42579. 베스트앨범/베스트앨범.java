import java.util.*;

class Solution {
    static class PlayCount implements Comparable<PlayCount> {
        String genre;
        int play;
        int number;
        
        public PlayCount (String genre, int play) {
            this.genre = genre;
            this.play = play;
        }
        
        public PlayCount(int play, int number) {
            this.play = play;
            this.number = number;
        }
        
        @Override
        public int compareTo(PlayCount other) {
            if (this.play == other.play) {
                return Integer.compare(this.number, other.number);
            }
            return Integer.compare(other.play, this.play);
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Set<PlayCount>> playCounter = new HashMap<>();
        Map<String, Integer> totalCountPerGenre = new HashMap<>();
        
        for (int i = 0; i < genres.length; ++i) {
            playCounter.computeIfAbsent(genres[i], k -> new TreeSet<>()).add(new PlayCount(plays[i], i));
            totalCountPerGenre.put(genres[i], totalCountPerGenre.getOrDefault(genres[i], 0) + plays[i]);  
        }
        
        List<PlayCount> temp = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : totalCountPerGenre.entrySet()) {
            temp.add(new PlayCount(entry.getKey(), entry.getValue()));
        }
        
        Collections.sort(temp);
                                                                             
        for (PlayCount key : temp) {
            int count = 0;
            for (PlayCount playCount : playCounter.get(key.genre)) {
                if (count > 1) break;
                answer.add(playCount.number);
                ++count;
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
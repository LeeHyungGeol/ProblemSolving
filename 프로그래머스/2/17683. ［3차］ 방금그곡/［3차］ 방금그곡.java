import java.util.*;

class Solution {
    private static final String NONE_MATCHING = "(None)";
    private static Map<String, String> musicalNotes = new HashMap<>(){{
        put("C#", "c");
        put("D#", "@");
        put("F#", "*");
        put("G#", "$");
        put("A#", "a"); 
        put("B#", "%");
    }};
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxPlayTime = 0;
        
        for (String info : musicinfos) {
            String[] split = info.split(",");
            int totalPlayedTime = timeToInt(split[1]) - timeToInt(split[0]);
            String musicName = split[2];
            String totalMusicInfo = getTotalMusicInfo(totalPlayedTime, convertMusicalNotes(split[3]));
            m = convertMusicalNotes(m);
            
            if (totalMusicInfo.contains(m) && maxPlayTime < totalPlayedTime) {
                answer = musicName;
                maxPlayTime = totalPlayedTime;
            }
        }
        
        if (answer.length() == 0) {
            return NONE_MATCHING;
        }
        
        return answer;
    }
    
    private String getTotalMusicInfo(int totalTime, String musicInfo) {
        return musicInfo.repeat(totalTime/musicInfo.length()) + musicInfo.substring(0, (totalTime%musicInfo.length()));
    }
    
    private String convertMusicalNotes(String input) {
        for (Map.Entry<String, String> entry : musicalNotes.entrySet()) {
            input = input.replace(entry.getKey(), entry.getValue());
        }
        return input;
    }
    
    private int timeToInt(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]); 
    }
}
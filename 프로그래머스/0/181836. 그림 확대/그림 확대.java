import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] picture, int k) {
//         String[] answer = new String[picture.length*k];

//         for (int i = 0; i < picture.length; ++i) {
//             String tmp = "";
//             for (String p : picture[i].split("")) {
//                 tmp += p.repeat(k);
//             }
//             for (int j = i; j < k; ++j) answer[j] = tmp;
//         }
        
//         return answer;
        
        return IntStream.range(0, picture.length * k)
                        .mapToObj(i -> IntStream.range(0, picture[i / k].length())
                                                .mapToObj(l -> String.valueOf(picture[i / k].charAt(l)).repeat(k))
                                                .collect(Collectors.joining()))
                        .toArray(String[]::new);

    }
}
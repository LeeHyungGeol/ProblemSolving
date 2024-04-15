import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public long solution(long n) {
//         String[] list = String.valueOf(n).split("");
//         Arrays.sort(list);
        
//         StringBuffer sb = new StringBuffer();
//         for (String s : list) sb.append(s);
        
//         return Long.parseLong(sb.reverse().toString());
        
        // return Long.parseLong(String.valueOf(n).chars().mapToObj(ch -> (char) ch)
                // .sorted(Comparator.reverseOrder())
                // .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                // .toString());
                return Long.parseLong(String.valueOf(n).chars().boxed().map(c->c-'0').sorted(Comparator.reverseOrder()).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());

    }
}
import java.util.*;

class Solution {
    private static Map<String, int[]> map = new HashMap<>(){{
        put("N", new int[]{-1,0});
        put("S", new int[]{1,0});
        put("W", new int[]{0,-1});
        put("E", new int[]{0,1});
    }};
    private static int x = 0, y = 0;
    private static int H = 0, W = 0;
    
    public int[] solution(String[] park, String[] routes) {
        H = park.length;
        W = park[0].length();
        
        for (int i = 0; i < park.length; ++i) {
            for (int j = 0; j < park[i].length(); ++j) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        
        for (String route : routes) {
            String[] splitRoute = route.split(" ");
            String op = splitRoute[0];
            int n = Integer.parseInt(splitRoute[1]);
            int[] d = map.get(op);
            int tempX=x, tempY=y;
            boolean flag = false;
            
            for (int i = 0; i < n; ++i) {
                 int a = x + d[0];
                 int b = y + d[1];
                
                if (a < 0 || a >= H || b < 0 || b >= W || park[a].charAt(b) == 'X') {
                    flag = true;
                    break;
                }
                x = a;
                y = b;
            }
            if (flag) {
                x = tempX;
                y = tempY;
            }
        }
        
        return new int[]{x,y};
    }
}
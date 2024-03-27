import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] map = {a,b,c,d};
        
        Arrays.sort(map);
        
        if(map[0]==map[3]) {
            return 1111 * map[0];
        } else if ((map[0]==map[2]) || map[1]==map[3]) {
            return map[0] == map[1] ? ((10*map[0])+map[3])*((10*map[0])+map[3]) : ((10*map[3])+map[0])*((10*map[3])+map[0]);
        } else if (map[0] == map[1] && map[1] != map[2] && map[2] == map[3]) {
            return (map[0] + map[3]) * Math.abs(map[0]-map[3]);
        } else if (map[0] == map[1] || map[1] == map[2] || map[2] == map[3]) {
            return map[0] == map[1] ? map[2]*map[3] : map[1] == map[2] ? map[0]*map[3] : map[0]*map[1]; 
        } else {
            return map[0];
        }
    }
}
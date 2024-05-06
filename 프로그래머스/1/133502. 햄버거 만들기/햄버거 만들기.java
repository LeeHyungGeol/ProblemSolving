class Solution {
    public int solution(int[] ingredient) {
//         int answer = 0;
//         StringBuilder sb = new StringBuilder();
        
//         for (int i : ingredient) {
//             sb.append(i);
//             if (sb.length() > 3 && sb.substring(sb.length()-4).toString().equals("1231")) {
//                 ++answer;
//                 sb.delete(sb.length()-4, sb.length());
//             }
//         }
        
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;
        for (int i : ingredient) {
            stack[sp++] = i;
            if (sp >= 4 && stack[sp - 1] == 1
                && stack[sp - 2] == 3
                && stack[sp - 3] == 2
                && stack[sp - 4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        
        return answer;
    }
}
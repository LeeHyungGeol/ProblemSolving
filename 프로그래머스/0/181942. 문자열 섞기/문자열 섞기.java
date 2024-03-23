class Solution {
    public String solution(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<chars1.length; i++) {
            sb.append(chars1[i]).append(chars2[i]);
        }

        return sb.toString();
    }
}
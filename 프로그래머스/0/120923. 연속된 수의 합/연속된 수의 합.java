class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        // start 를 설정하는 규칙을 찾는게 중요하다!!
        int start = (total/num) - (num-1)/2;
        for (int i = 0; i < num; ++i) answer[i] = start+i;
        return answer;
    }
}
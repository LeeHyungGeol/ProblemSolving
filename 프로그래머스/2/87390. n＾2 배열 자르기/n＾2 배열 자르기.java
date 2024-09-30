// % 연산을 자주 생각해보자. 코딩테스트 풀이에서 쓰임새가 많은 것 같다.
// 결국.. 규칙성을 찾는 문제..
// 규칙: (행, 열)중 가장 큰 값 Math.max(행, 열)이 그 행열의 값이 된다.

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
 
        int idx = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n + 1;
            long col = i % n + 1;
            answer[idx++] = (int) Math.max(row, col);
        }
 
        return answer;
    }
}
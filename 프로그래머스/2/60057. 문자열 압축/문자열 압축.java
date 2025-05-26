import java.util.stream.IntStream;

class Solution {

    public int solution(String s) {
        int length = s.length();
        // 1부터 length/2 까지의 모든 chunk 크기에 대해 compress 길이를 계산 → 최솟값
        return IntStream.rangeClosed(1, length / 2)
                        .map(chunkSize -> compress(s, chunkSize))
                        .min()
                        .orElse(length);    // 아무것도 못 찾으면 원본 길이
    }

    /**
     * 주어진 chunkSize 로 s 를 잘라서 연속된 같은 조각을 숫자+조각 문자열 형태로 압축했을 때의 길이 반환
     */
    private int compress(String s, int chunkSize) {
        StringBuilder sb = new StringBuilder();
        String prev = "";    // 직전 조각
        int count = 0;       // 같은 조각이 몇 번 연속됐는지

        for (int i = 0; i < s.length(); i += chunkSize) {
            String cur = s.substring(i, Math.min(s.length(), i + chunkSize));
            if (cur.equals(prev)) {
                count++;
            } else {
                // 새 조각이 나왔으니 이전까지 모아둔 count·prev 를 sb 에 붙이고
                if (count > 1) sb.append(count).append(prev);
                else sb.append(prev);
                prev = cur;
                count = 1;
            }
        }
        // 마지막까지 남은 prev/count 처리
        if (count > 1) sb.append(count).append(prev);
        else sb.append(prev);

        return sb.length();
    }
}

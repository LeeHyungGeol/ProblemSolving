class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = {};
        answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                StringBuilder binary = new StringBuilder(Long.toBinaryString(numbers[i]));
                int len = binary.length();
                if (binary.toString().contains("01")) {
                    for (int j = len; j > 0; --j) {
                        if (binary.substring(j - 2, j).equals("01")) {
                            binary.setCharAt(j - 1, '0');
                            binary.setCharAt(j - 2, '1');
                            break;
                        }
                    }
                } else {
                    binary.deleteCharAt(0);
                    binary.insert(0, "10");
                }
                answer[i] = Long.valueOf(binary.toString(), 2);
            }
        }
        return answer;
    }
}
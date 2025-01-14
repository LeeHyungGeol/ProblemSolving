import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기: n (리스트 크기), m (폭발 기준 개수)
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        // 리스트 입력 받기
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        sc.close(); // Scanner 닫기

        // 연쇄 폭발 시뮬레이션
        while (true) {
            boolean didExplode = false;

            // 리스트를 순회하며 폭탄 체크
            int start = 0;
            while (start < arr.size()) {
                int num = arr.get(start);
                if (num == 0) {
                    start++;
                    continue;
                }

                // 폭발 가능한 마지막 위치 찾기
                int end = countExplodeBomb(arr, start, num);

                // 연속된 폭탄 개수가 m 이상이면 폭발
                if ((end - start + 1) >= m) {
                    for (int i = start; i <= end; i++) {
                        arr.set(i, 0); // 0으로 표시
                    }
                    didExplode = true;
                }

                start = end + 1;
            }

            // 0을 제거한 새로운 리스트 생성
            arr.removeIf(x -> x == 0);

            // 더 이상 폭발이 없으면 루프 종료
            if (!didExplode) {
                break;
            }
        }

        // 결과 출력
        System.out.println(arr.size());
        for (int num : arr) {
            System.out.println(num);
        }
    }

    // 특정 숫자(num)와 같은 값이 연속된 마지막 위치를 찾는 함수
    private static int countExplodeBomb(List<Integer> arr, int start, int num) {
        int end = start;
        while (end + 1 < arr.size() && arr.get(end + 1) == num) {
            end++;
        }
        return end;
    }
}
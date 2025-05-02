class Solution {
    public String pushDominoes(String S) {
        int N = S.length();
        char[] A = S.toCharArray();
        // forces[i]: i번 칸에 대한 “순수 힘(오른쪽으로 플러스, 왼쪽으로 마이너스)”
        int[] forces = new int[N];

        // 1) 왼→오 스캔: 'R' 만나면 force=N, 'L' 만나면 force=0, 그 외는 force–1
        int force = 0;
        for (int i = 0; i < N; ++i) {
            if      (A[i] == 'R') force = N;
            else if (A[i] == 'L') force = 0;
            else                  force = Math.max(force - 1, 0);
            forces[i] += force;
        }

        // 2) 오→왼 스캔: 'L' 만나면 force=N, 'R' 만나면 force=0, 그 외는 force–1
        force = 0;
        for (int i = N - 1; i >= 0; --i) {
            if      (A[i] == 'L') force = N;
            else if (A[i] == 'R') force = 0;
            else                  force = Math.max(force - 1, 0);
            forces[i] -= force;
        }

        // 3) 최종 문자열 생성: forces[i] > 0 → 'R', < 0 → 'L', = 0 → '.'
        StringBuilder ans = new StringBuilder();
        for (int f : forces) {
            if      (f > 0)  ans.append('R');
            else if (f < 0)  ans.append('L');
            else             ans.append('.');
        }
        return ans.toString();
    }
}

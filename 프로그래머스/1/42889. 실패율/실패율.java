import java.util.*;

// 뿌듯 ^ㅡ^
// [두 수의 비교 결과에 따른 작동 방식]

// 음수일 경우 : 두 원소의 위치를 교환 안함

// 양수일 경우 : 두 원소의 위치를 교환 함
class Solution {
    class Failure {
        private int stageNumber;
        private double fail;
        
        public Failure(int stageNumber, double fail) {
            this.stageNumber = stageNumber;
            this.fail = fail;
        }
        
        public int getStageNumber() {
            return stageNumber;
        }
        
        public double getFail() {
            return fail;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        List<Failure> list = new LinkedList<>();
        int[] answer = new int[N];
        
        for (int i = 1; i <= N; ++i) {
            int notClear = 0, reach = 0;
            
            for (int j = 0; j < stages.length; ++j) {
                if (stages[j] == i) ++notClear;
                if (stages[j] >= i) ++reach;
            }
            if (reach == 0) list.add(new Failure(i, 0));
            else list.add(new Failure(i, (double)notClear/reach));
        }
        
        Collections.sort(list, new Comparator<Failure>(){
            @Override
            public int compare(Failure o1, Failure o2) {
                if (o1.getFail() < o2.getFail()) return 1;
                else if (o1.getFail() > o2.getFail()) return -1;
                else return 0;
            }
        });
        
        for (int i = 0; i < list.size(); ++i) answer[i] = list.get(i).getStageNumber();

        return answer;
    }
}
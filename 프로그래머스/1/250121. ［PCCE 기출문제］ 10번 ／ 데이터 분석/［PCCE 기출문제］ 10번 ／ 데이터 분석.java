import java.util.*;

class Solution {
    private static String sortBy = "";
    static class Node implements Comparable<Node> {
        private int code;
        private int date;
        private int maximum;
        private int remain;
        
        public Node(int code, int date, int maximum, int remain) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
        
        public int getCode() {
            return this.code;
        }
        
        public int getDate() {
            return this.date;
        }
        
        public int getMaximum() {
            return this.maximum;
        }
        
        public int getRemain() {
            return this.remain;
        }
        
        @Override
        public int compareTo(Node other) {
            if (sortBy.equals("code")) {
                if (this.getCode() < other.getCode()) return -1;
                else return 1;
            } else if (sortBy.equals("date")) {
                if (this.getDate() < other.getDate()) return -1;
                else return 1;
            } else if (sortBy.equals("maximum")) {
                if (this.getMaximum() < other.getMaximum()) return -1;
                else return 1;
            }
            if (this.getRemain() < other.getRemain()) return -1;
            return 1;
        }
    }
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        sortBy = sort_by;
        List<Node> list = new ArrayList<>();
        
        for (int[] d : data) {
            if (ext.equals("code") && d[0] < val_ext) {
                list.add(new Node(d[0], d[1], d[2], d[3]));
            } else if (ext.equals("date") && d[1] < val_ext) {
                list.add(new Node(d[0], d[1], d[2], d[3]));
            } else if (ext.equals("maximum") && d[2] < val_ext) {
                list.add(new Node(d[0], d[1], d[2], d[3]));
            } else if (ext.equals("remain") && d[3] < val_ext){
                list.add(new Node(d[0], d[1], d[2], d[3]));
            }   
        }
        
        Collections.sort(list);
        
        int i = 0;
        int[][] answer = new int[list.size()][];
        for (Node n : list) {
            answer[i++] = new int[]{n.getCode(), n.getDate(), n.getMaximum(), n.getRemain()};
        }
        
        return answer;
    }
}
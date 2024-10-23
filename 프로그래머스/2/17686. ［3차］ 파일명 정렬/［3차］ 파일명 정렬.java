import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        private String original;
        private String head;
        private int number;
        private String tail;
        
        public Node(String original, String head, int number, String tail) {
            this.original = original;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        @Override
        public int compareTo(Node other) {
            // HEAD 비교 (대소문자 구분 없이)
            int headComparison = this.head.compareToIgnoreCase(other.head);
            if (headComparison != 0) {
                return headComparison;
            }

            // NUMBER 비교
            return Integer.compare(this.number, other.number);
        }

        public String getOriginal() {
            return original;
        }
    }
    
    public String[] solution(String[] files) {
        List<Node> list = new ArrayList<>();
        String[] answer = new String[files.length];
        
        for (int i = 0; i < files.length; ++i) {
            String file = files[i];
            
            int j = 0;
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();
            while (j < file.length() && !Character.isDigit(file.charAt(j))) {
                head.append(file.charAt(j));
                ++j;
            }
            
            while (j < file.length() && Character.isDigit(file.charAt(j))) {
                number.append(file.charAt(j));
                ++j;
            }
            
            if (j < file.length()) {
                tail.append(file.substring(j));
            }
            
            if (number.toString().equals("")) {
                number.append("0");
            }
            
            list.add(new Node(files[i], head.toString(), Integer.parseInt(number.toString()), tail.toString()));
        }
        
        Collections.sort(list);
        
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(i).getOriginal();
        }
        
        return answer;
    }
}
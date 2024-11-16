import java.util.*;

class Solution {
    private static long answer = 0;
    private static String[] operator = {"+","-","*"};
    private static String[] priorities = new String[3];
    private static boolean[] visited = new boolean[3];
    private static List<Long> numbers = new ArrayList<>();
    private static List<String> operands = new ArrayList<>();
    
    public long solution(String expression) {
        splitToNumbersOperands(expression);
        
        dfs(0);
        
        return answer;
    }
    
    private void dfs(int size) {
        if (size == 3) {
            getMax();
            return;
        }
        
        for (int i = 0; i < 3; ++i) {
            if (visited[i]) continue;
            visited[i] = true;
            priorities[size] = operator[i];
            dfs(size+1);
            visited[i] = false;
        }
    }
    
    private void getMax(){
        ArrayList<String> oper = new ArrayList<String>();
        oper.addAll(operands);
        
        ArrayList<Long> num = new ArrayList<Long>();
        num.addAll(numbers);
        
        for(int i = 0; i < priorities.length; ++i){
            String op = priorities[i];
            for(int j = 0; j < oper.size(); ++j){
                if(oper.get(j).equals(op)){
                    long a = num.get(j);
                    long b = num.get(j+1);
                    long result = cal(a, b, op);
                    
                    num.remove(j+1);
                    num.remove(j);
                    oper.remove(j);
                    
                    num.add(j, result);
                    
                    --j;
                }
            }
        }
        
        answer = Math.max(answer, Math.abs(num.get(0)));
    }
    
    private long cal(long a, long b, String op){
        long result = 0;
        
        switch(op){
            case "*": 
                result = a * b;
                break;
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
        }
        
        return result;
    }
   
    private void splitToNumbersOperands(String expression) {
        String number = "";
        
        for (int i = 0; i < expression.length(); ++i) {
            if (Character.isDigit(expression.charAt(i))) {
                number += expression.charAt(i);
            } else {
                numbers.add(Long.parseLong(number));
                operands.add(String.valueOf(expression.charAt(i)));
                number = "";
            }
        }
        numbers.add(Long.parseLong(number));
        
        return;
    }
}
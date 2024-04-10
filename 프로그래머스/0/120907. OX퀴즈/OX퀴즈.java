import java.util.Arrays;

class Solution {
    public String[] solution(String[] quiz) {
        return Arrays.stream(quiz).map(i -> {
            String[] arr = i.split(" ");
            return arr[1].equals("+") ? Integer.parseInt(arr[0])+Integer.parseInt(arr[2]) == Integer.parseInt(arr[4]) : Integer.parseInt(arr[0])-Integer.parseInt(arr[2]) == Integer.parseInt(arr[4]);
        }).map(i-> i ? "O" : "X").toArray(String[]::new);    
    }
}
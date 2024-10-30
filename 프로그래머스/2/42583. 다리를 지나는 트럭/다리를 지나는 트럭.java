import java.util.*;

class Solution {
    static class Truck {
        private int weight;
        private int move;
        
        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }
        
        public void moving() {
            ++this.move;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waitQueue = new LinkedList<>();
        Queue<Truck> moveQueue = new LinkedList<>();
        
        for (int truckWeight : truck_weights) {
            waitQueue.add(new Truck(truckWeight));
        }
            
        int answer = 0;
        int currentWeight = 0;
        
        while (!waitQueue.isEmpty() || !moveQueue.isEmpty()) {
            ++answer;
            
            if (moveQueue.isEmpty()) {
                Truck truck = waitQueue.poll();
                moveQueue.add(truck);
                currentWeight += truck.weight;
                continue;
            }
            
            for (Truck truck : moveQueue) {
                truck.moving();
            }
            
            if (moveQueue.peek().move > bridge_length) {
                Truck truck = moveQueue.poll();
                currentWeight -= truck.weight;
            }
            
            if (!waitQueue.isEmpty() && waitQueue.peek().weight + currentWeight <= weight) {
                Truck truck = waitQueue.poll();
                currentWeight += truck.weight;
                moveQueue.add(truck);
            }
        }
        
        return answer;
    }
}
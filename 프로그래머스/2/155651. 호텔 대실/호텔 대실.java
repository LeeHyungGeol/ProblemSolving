// 시작 시간이 빠른 것을 기준으로 정렬(시작시간이 같다면 끝나는 시간이 빠른 순으로)
// BookTime class 를 생성해서 관리하면 어떨까? List<BookTime> list = new ArrayList<>(); 
// BookTime 에는 시작 시간, 끝나는 시간을 필드로 갖는다.
// Map 도 필요할지도?
// EX) 11:11 -> (60*11) + 11 로 변환해서 저장하자.
// 청소시간 10분 필요한 것도 잊지말자.
import java.util.*;

class Solution {
    static class BookTime implements Comparable<BookTime>{
        private int startTime;
        private int endTime;
        
        public BookTime(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime+10;
        }
        
        public int getStartTime() {
            return this.startTime;
        }
        
        public int getEndTime() {
            return this.endTime;
        }
        
        @Override
        public int compareTo(BookTime other) {
            return Integer.compare(this.getEndTime(), other.getEndTime());
        }
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        List<BookTime> times = new ArrayList<>();
        PriorityQueue<BookTime> pq = new PriorityQueue<>();
        
        for (String[] time : book_time) {
            times.add(new BookTime(timeToInt(time[0]), timeToInt(time[1])));
        }
        
        Collections.sort(times, new Comparator<BookTime>(){
           public int compare(BookTime a, BookTime b) {
               if (a.getStartTime() == b.getStartTime()) {
                   return Integer.compare(a.getEndTime(), b.getEndTime());
               }
               return Integer.compare(a.getStartTime(), b.getStartTime());
           } 
        });
        
        for (BookTime bookTime : times) {
            if (pq.isEmpty()) {
                pq.add(bookTime);
                continue;
            }
            if (bookTime.getStartTime() < pq.peek().getEndTime()) {
                pq.add(bookTime);
            } else {
                pq.poll();
                pq.add(bookTime);                
            }
        }

        return pq.size();
    }
    
    private int timeToInt(String time) {
        String[] split = time.split(":");
        return (Integer.parseInt(split[0])*60) + Integer.parseInt(split[1]); 
    }
}
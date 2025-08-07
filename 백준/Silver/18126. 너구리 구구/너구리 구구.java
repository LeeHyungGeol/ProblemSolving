import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node{
		int index;
		long value;
        
		public Node(int index, long value) {
			this.index = index;
			this.value = value;
		}
	}
    
    private static long answer = Integer.MIN_VALUE;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i <= N; ++i)
        	graph.add(new ArrayList<>());
        
        StringTokenizer st;
        
        for(int i=1; i < N; ++i) {
        	st = new StringTokenizer(br.readLine()," ");
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	int C = Integer.parseInt(st.nextToken());
        	graph.get(A).add(new Node(B,C));
        	graph.get(B).add(new Node(A,C));
        }
        
        bfs(N);	
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
    
    private static void bfs(int N) {
    	Queue<Node> queue = new ArrayDeque<>();
    	boolean[] visited = new boolean[N+1];
    	
        visited[1] = true;
    	queue.offer(new Node(1, 0));

        while(!queue.isEmpty()) {
    		boolean flag = false;
    		Node cur = queue.poll();

            for (Node next : graph.get(cur.index)) {
    			if(!visited[next.index]) {
    				flag = true;
    				visited[next.index] = true;
    				queue.add(new Node(next.index, cur.value + next.value));
    			}
    		}
            
    		if(!flag)	
    			answer = Math.max(answer,  cur.value);
    	}
    }
}
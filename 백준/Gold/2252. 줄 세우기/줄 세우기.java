import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] inD = new int[N+1];
		Node[] adjList = new Node[N+1];
		
		//그래프 만들기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			inD[to]++;
		}
		
		StringBuilder sb = new StringBuilder();
		//위상 정렬
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i < inD.length; i++) {
			if (inD[i] == 0) q.add(i);
		}
		while (!q.isEmpty()) {
			int start = q.poll();
			sb.append(start+" ");
			
			
			for (Node i = adjList[start]; i != null; i = i.next) {
				if (--inD[i.vertex] == 0) {
					q.add(i.vertex);
				}
			}
		}
		
		System.out.println(sb);
	}
}


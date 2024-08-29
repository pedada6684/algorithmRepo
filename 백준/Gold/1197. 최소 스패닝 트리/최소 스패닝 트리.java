import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Vertex{
		int e,w;

		public Vertex(int e, int w) {
			super();
			this.e = e;
			this.w = w;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<Vertex>[] adjlst = new ArrayList[V+1];
		for (int i = 0; i < adjlst.length; i++) {
			adjlst[i] = new ArrayList<Vertex>();
		}
		
		boolean[] visited = new boolean[V+1];
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjlst[s].add(new Vertex(e, w));
			adjlst[e].add(new Vertex(s, w));
		}
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>((a,b) ->{return a.w - b.w;});
		pq.add(new Vertex(1, dist[1]));
		
		long ans = 0;
        int cnt  = 0;
		while (!pq.isEmpty()) {
			Vertex nowV = pq.poll();
			if (visited[nowV.e]) continue;
			visited[nowV.e] = true;
			ans += nowV.w;
            if (++cnt == V) break;
			for (Vertex nextV : adjlst[nowV.e]) {
				int e = nextV.e;
				int w = nextV.w;
				if (!visited[e] && dist[e] > w) {
					dist[e] = w;
					pq.add(new Vertex(e, w));
				}
			}
		}
		System.out.println(ans);
	}

}


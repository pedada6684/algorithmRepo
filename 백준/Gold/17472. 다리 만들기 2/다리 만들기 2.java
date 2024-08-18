import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<ArrayList<int[]>> island = new ArrayList<ArrayList<int[]>>();
		
		
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (!v[i][j] && map[i][j] != 0) {
					island.add(bfs(i,j,++cnt));
				}
			}
		}
		
		int[][] dist = new int[cnt+1][cnt+1];
		for (int[] x : dist) {
			Arrays.fill(x, Integer.MAX_VALUE);
		}
		
		for (ArrayList<int[]> land : island) {
			for (int[] xy : land) {
				int x = xy[0];
				int y = xy[1];
				for (int d = 0; d < dx.length; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					int bridgeL = 0;
					while ((0 <= nx && 0 <= ny && N > nx && M > ny && map[nx][ny] != map[x][y])) {
						if (map[nx][ny] != 0) {//다른 섬 도착 	
							if (bridgeL < 2) break;
							int s = map[x][y];
							int e = map[nx][ny];
							dist[s][e] = Math.min(dist[s][e], bridgeL);
							dist[e][s] = dist[s][e];
							break;
						}
						bridgeL++;
						nx += dx[d];
						ny += dy[d];
					}
				}
			}
		}
		int union = 0;
		int ans = 0;
		boolean[] iv = new boolean[cnt+1];
		iv[0] = true;
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> {return a[2]- b[2];});
		pq.add(new int[] {1,1,0});
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int s = now[1];
			int w = now[2];
			if (iv[s]) continue;
			iv[s] = true;
			ans += w;
			if (++union == cnt) break;
			
			for (int d = 1; d < dist.length; d++) {
				if (dist[s][d] == Integer.MAX_VALUE || iv[d]) continue;
				pq.add(new int[] {s, d, dist[s][d]});
			}
		}
		if (union != cnt || ans == 0) {
			System.out.println(-1);
		}else {			
			System.out.println(ans);
		}
		
	}
	private static ArrayList<int[]> bfs(int i, int j, int cnt) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {i,j});
		list.add(new int[] {i,j});
		v[i][j] = true;
		map[i][j] = cnt;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nx = now[0]+ dx[d];
				int ny = now[1]+ dy[d];
				if (0 <= nx && 0 <= ny && N > nx && M > ny && !v[nx][ny] && map[nx][ny] != 0) {
					q.add(new int[] {nx,ny});
					list.add(new int[] {nx,ny});
					map[nx][ny] = cnt;
					v[nx][ny] = true;
				}
			}
		}
		return list;
	}
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static int[][][]dist;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dist = new int[N][M][2];
		//거리배열 
		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = str.charAt(j)-'0';
				dist[i][j][0] = Integer.MAX_VALUE;
				dist[i][j][1] = Integer.MAX_VALUE;
			}
		}
		dist[0][0][0] = 1;
		int endPoint = Integer.MAX_VALUE;
		boolean flag = false;
		
		//bfs
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0,0,0});
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int c = q.poll()[2];
			
			if (x == N-1 && y == M-1) {				
				endPoint = Math.min(dist[N-1][M-1][0], dist[N-1][M-1][1]);
				break;
			}
			for (int d = 0; d < dx.length; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if (0<= nx && 0<= ny && N> nx && M> ny) {
					if (map[nx][ny] == 1) {
						if(c==1) continue;
						
						dist[nx][ny][1] = dist[x][y][c]+1;
						q.add(new int[] {nx,ny,1});
						
					}else {
						if (dist[nx][ny][c] == Integer.MAX_VALUE) {
							dist[nx][ny][c] = dist[x][y][c]+1;
							q.add(new int[] {nx,ny,c});
						}
					}
				}
			}
		}
		//도달해서 끝난 
		if (dist[N-1][M-1][0] != Integer.MAX_VALUE || dist[N-1][M-1][1] != Integer.MAX_VALUE ){
			System.out.println((dist[N-1][M-1][0] > dist[N-1][M-1][1])? dist[N-1][M-1][1] : dist[N-1][M-1][0]);
			return;
		}
		System.out.println(-1);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new int[N][N];
		sol(0);
		System.out.println(ans);
	}
	private static void sol(int i) {
		if (i == map.length) {
			ans++;
			return;
		}
for (int j = 0; j < map.length; j++) {
			boolean flag = false;
			//체크
			for (int k = 1; k <= i; k++) {
				if (  map[i-k][j] == 1 
						|| (j-k >= 0 &&  map[i-k][j-k] == 1) 
						|| (j+k < map.length && map[i-k][j+k] == 1)) {
					flag = true;
					break;
				}
			}
			if (flag) continue;
			map[i][j] = 1;
			sol(i+1);
			map[i][j] = 0;
		}
	}
}


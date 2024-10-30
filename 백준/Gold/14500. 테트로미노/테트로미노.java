import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] v;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        v = new boolean[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                v[i][j] = true;
                dfs(i,j,0, map[i][j]);
                v[i][j] = false;
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int idx, int sum) {
        if (idx == 3){
            ans = Math.max(ans, sum);
            return;
        }
        for (int d = 0; d < 4; d++) {
            int nx = x+dx[d];
            int ny = y+dy[d];
            if (0<= nx && nx < map.length && 0 <= ny && ny < map[0].length && !v[nx][ny]){
                v[nx][ny] = true;
                dfs(nx, ny, idx+1, sum+map[nx][ny]);
                v[nx][ny] = false;
            }
        }
        if (idx == 1){
            for (int d = 0; d < 3; d++) {
                for (int dd = d+1; dd < 4; dd++) {
                    int nx = x+dx[d];
                    int ny = y+dy[d];
                    int nnx = x+dx[dd];
                    int nny = y+dy[dd];
                    if (
                            0<= nx && nx < map.length && 0 <= ny && ny < map[0].length && !v[nx][ny] &&
                            0<= nnx && nnx < map.length && 0 <= nny && nny < map[0].length && !v[nnx][nny]
                    ){
                        dfs(nx, ny, 3, sum+map[nx][ny]+map[nnx][nny]);
                    }
                }
            }
        }
    }
}

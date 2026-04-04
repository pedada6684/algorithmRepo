import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        memo = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                memo[i][j] = -1;
            }
        }
        memo[N-1][M-1] = 1;

        System.out.println(dp(0, 0));
    }

    static int dp (int x, int y){
        if(memo[x][y] != -1){
            return memo[x][y];
        }
        memo[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<= nx && nx<map.length && 0 <= ny && ny < map[0].length && map[x][y] > map[nx][ny]){
                memo[x][y] += dp(nx,ny);
            }
        }

        return memo[x][y];
    }
}

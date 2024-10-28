import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 2){
                    q.add(new int[]{i,j});
                    x = 1;
                }
                map[i][j] = x;
            }
        }
        int[][] ans = new int[N][M];
        boolean[][] v = new boolean[N][M];
        while (!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            if (v[x][y]) continue;
            v[x][y] = true;
            for (int d = 0; d < 4; d++) {
                int nx = x+dx[d];
                int ny = y+dy[d];
                if (0 <= nx && nx < N && 0<= ny && ny < M && map[nx][ny] == 1 && !v[nx][ny]){
                    ans[nx][ny] = ans[x][y]+1;
                    q.add(new int[] {nx,ny});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int a = ans[i][j];
                if (map[i][j] != 0 && a == 0 && !v[i][j]) a = -1;
                sb.append(a+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}

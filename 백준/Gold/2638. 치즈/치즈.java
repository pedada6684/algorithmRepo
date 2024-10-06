import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static int N;
    static int M;
    static int total;
    static Set<int[]> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1){
                    total++;
                }
            }
        }
        int time = 0;
        while (total > 0){
            checkCoast();
            deleteCheese();
            time++;
        }
        System.out.println(time);
    }

    private static void deleteCheese() {
        for (int[] xy : set) {
            int x = xy[0];
            int y = xy[1];
            if (map[x][y] == 1){
                map[x][y] = 0;
                total--;
            }
        }
        set = new HashSet<>();
    }

    private static void checkCoast() {
        boolean[][] v = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});
        while (!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.poll()[1];
            if (v[x][y]) continue;
            v[x][y] = true;
            for (int d = 0; d < 4; d++) {
                int nx = x+dx[d];
                int ny = y+dy[d];
                if (0 <= nx && nx < N && 0 <= ny && ny < M){
                    if (map[nx][ny] == 1){
                        if (v[nx][ny]){
                            set.add(new int[] {nx, ny});
                        }else{
                            v[nx][ny] = true;
                        }
                    }else if (!v[nx][ny]){
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}

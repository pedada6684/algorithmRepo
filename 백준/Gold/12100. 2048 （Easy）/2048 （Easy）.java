import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] mapO = new int[N][N];
        int maxv = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                mapO[i][j] = Integer.parseInt(st.nextToken());
                maxv = Math.max(maxv, mapO[i][j]);
            }
        }
        Queue<State> q = new LinkedList<>();
        q.add(new State(clone(mapO), 0, maxv));
        while (!q.isEmpty()){
            State now = q.poll();
            if (now.cnt == 5){
                maxv = Math.max(maxv, now.max);
                continue;
            }
            for (int d = 0; d < 4; d++) {
                    q.add(move(now, d));
            }
        }
        System.out.println(maxv);
    }

    private static int[][] clone(int[][] mapO) {
        int[][] map = new int[mapO.length][mapO.length];
        for (int i = 0; i < mapO.length; i++) {
            map[i] = mapO[i].clone();
        }
        return map;
    }

    private static State move(State now, int d) {
        int max = now.max;
        int[][] map = clone(now.map);
        map = drop(map, d);
        
        int startI = (d < 2) ? 0 : map.length - 1;
        int endI = (d < 2) ? map.length : -1;
        int stepI = (d < 2) ? 1 : -1;
        int startJ = (d < 2) ? 0 : map.length - 1;
        int endJ = (d < 2) ? map.length : -1;
        int stepJ = (d < 2) ? 1 : -1;
        
        for (int i = startI; i != endI; i += stepI) {
            for (int j = startJ; j != endJ; j += stepJ) {//합치기
                int nexti = i+dx[d];
                int nextj = j+dy[d];
                if (0<= nexti && nexti < map.length && 0<= nextj && nextj < map.length && map[i][j] == map[nexti][nextj]){
                    map[nexti][nextj] *= 2;
                    map[i][j] = 0;
                    max = Math.max(max, map[nexti][nextj]);
                }
            }
        }
        map = drop(map, d);
        return new State(map, now.cnt+1, max);
    }

    private static int[][] drop(int[][] map, int d) {
        int startI = (d < 2) ? 0 : map.length - 1;
        int endI = (d < 2) ? map.length : -1;
        int stepI = (d < 2) ? 1 : -1;

        int startJ = (d < 2) ? 0 : map.length - 1;
        int endJ = (d < 2) ? map.length : -1;
        int stepJ = (d < 2) ? 1 : -1;

        for (int i = startI; i != endI; i += stepI) {
            for (int j = startJ; j != endJ; j += stepJ) {
                int nowi = i;
                int nowj = j;
                while (true) {
                    int nexti = nowi + dx[d];
                    int nextj = nowj + dy[d];
                    if (0 <= nexti && nexti < map.length && 0 <= nextj && nextj < map.length && map[nexti][nextj] == 0) {
                        map[nexti][nextj] = map[nowi][nowj];
                        map[nowi][nowj] = 0;
                        nowi = nexti;
                        nowj = nextj;
                    } else {
                        break;
                    }
                }
            }
        }
        return map;
    }

    private static class State {
        int[][] map;
        int cnt;
        int max;

        public State(int[][] map, int cnt, int max) {
            this.map = map;
            this.cnt = cnt;
            this.max = max;
        }
    }
}
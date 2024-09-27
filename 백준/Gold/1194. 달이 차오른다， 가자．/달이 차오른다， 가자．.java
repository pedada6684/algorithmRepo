import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        char[][][] map = new char[N][M][(1<<6)];
        boolean[][][] v = new boolean[N][M][(1<<6)];
        int[][] step = new int[N][M];
        for (int[] ints : step) {
            Arrays.fill(ints, -1);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if (c == '1') c = 'G';
                if (c == '0') {
                    c = 'S';
                    q.add(new int[] {i,j,0});
                    step[i][j] = 0;
                }
                for (int k = 0; k < map[i][j].length; k++) {
                    map[i][j][k] = c;
                }
            }
        }
        while (!q.isEmpty()){
            int[] position = q.poll();
            int x = position[0];
            int y = position[1];
            int state = position[2];
            if (v[x][y][state]) continue;
            v[x][y][state] = true;
            for (int d = 0; d < 4; d++) {
                int nx = x+dx[d];
                int ny = y+dy[d];
                int nextState = state;
                if ( 0 <= nx && nx < N && 0 <= ny && ny < M && !v[nx][ny][nextState] && map[nx][ny][state] != '#'){
                    char c = map[nx][ny][state];
                    if ('a' <= c && c <= 'f'){
                        nextState = state | (1<<(c-'a'));
                    }else if ('A' <= c && c <= 'F' && (state & 1<<(c-'A')) == 0){
                        continue;
                    }else if (c == 'G'){
                        System.out.println(step[x][y] + 1);
                        return;
                    }
                    step[nx][ny] = step[x][y]+1;
                    q.add(new int[] {nx, ny, nextState});
                }
            }
        }
        System.out.println(-1);
    }
}
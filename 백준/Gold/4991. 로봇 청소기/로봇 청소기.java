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
        StringBuilder sb = new StringBuilder();
        test: while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break test;
            char[][] mapO = new char[N][M];
            int[][] step = new int[N][M];
            for (int i = 0; i < N; i++) {
                Arrays.fill(step[i], -1);
            }

            Queue<int[]> q = new LinkedList<>();
            int dust = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int j = 0; j < M; j++) {
                    char c = s.charAt(j);
                    if (c == 'o') {
                        c = 'S';
                        q.add(new int[]{i,j,0});
                        step[i][j] = 0;
                    }
                    if (c == '*') {
                        c = (char)(dust + 'a');
                        dust++;
                    }
                    mapO[i][j] = c;
                }
            }
            boolean[][][] v = new boolean[N][M][1<<dust];
            char[][][] map = new char[N][M][1<<dust];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    for (int k = 0; k < map[0][0].length; k++) {
                        map[i][j][k] = mapO[i][j];
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
                if (state == (1<<dust)-1) {
                    sb.append(step[x][y]+"\n");
                    continue test;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = x+dx[d];
                    int ny = y+dy[d];
                    int nextState = state;
                    if (0<= nx && nx < N && 0<= ny && ny < M && !v[nx][ny][nextState] && map[nx][ny][nextState] != 'x'){
                        char c = map[nx][ny][nextState];
                        if ('a' <= c && c <= 'z'){
                            nextState |= (1<<(c-'a'));
                        }
                        step[nx][ny] = step[x][y] +1;
                        q.add(new int[]{nx,ny,nextState});
                    }
                }
            }
            sb.append(-1+"\n");
        }
        System.out.println(sb.toString().trim());
    }
}
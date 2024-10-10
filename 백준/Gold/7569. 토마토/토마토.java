import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] map = new int[N][M][H];
        boolean[][][] v = new boolean[N][M][H];
        Queue<int[]> muturalTomamto = new LinkedList<>();
        int cnt = 0;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1){
                        muturalTomamto.add(new int[] {i,j,k});
                    } else if (map[i][j][k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        int time = 0;
        while (cnt > 0 && !muturalTomamto.isEmpty()){
            int size = muturalTomamto.size();
            for (int s = 0; s < size; s++) {
                int[] now = muturalTomamto.poll();
                int x = now[0];
                int y = now[1];
                int z = now[2];
                for (int d = 0; d < 6; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    int nz = z + dz[d];
                    if (0 <= nx && nx < N && 0 <= ny && ny < M && 0 <= nz && nz < H && !v[nx][ny][nz] && map[nx][ny][nz] == 0){
                        cnt--;
                        map[nx][ny][nz] = 1;
                        v[nx][ny][nz] = true;
                        muturalTomamto.add(new int[] {nx, ny, nz});
                    }
                }
            }
            time++;
        }
        if (cnt != 0){
            System.out.println(-1);
        }else{
            System.out.println(time);
        }
    }
}

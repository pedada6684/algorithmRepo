import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[] now = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        it: for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (now[j] + map[j][i] >= K){
                    sb.append((j+1)+" "+(i+1));
                    break it;
                }
                now[j] += map[j][i];
            }
        }
        System.out.println(sb.toString().trim());

    }
}

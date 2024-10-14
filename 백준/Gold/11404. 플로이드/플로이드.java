import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static final int MAXV = 100000*101;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] distance = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], MAXV);
            distance[i][i] = 0;
        }
        
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            distance[s][e] = Math.min(cost, distance[s][e]);
        }
        for (int m = 0; m < N; m++) {
            for (int s = 0; s < N; s++) {
                for (int e = 0; e < N; e++) {
                    distance[s][e] = Math.min(distance[s][e], distance[s][m] + distance[m][e]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int d = distance[i][j];
                if (d == 0 || d == MAXV) d = 0;
                sb.append(d+" ");
            }
            sb.replace(sb.length()-1, sb.length(), "\n");
        }
        System.out.println(sb.toString().trim());
    }
}

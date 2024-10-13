import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAXV = 102;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] distance = new int[N][N];
        for (int i = 0; i < distance.length; i++) {
            Arrays.fill(distance[i], MAXV);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            distance[a][b] = 1;
            distance[b][a] = 1;
        }
        for (int x = 0; x < 2; x++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    for (int k = 0; k < N; k++) {
                        if (j == k) continue;
                        if (distance[i][k] > distance[i][j] + distance[j][k]) {
                            distance[i][k] = distance[i][j] + distance[j][k];
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = N-1; i >= 0 ; i--) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (i == j || distance[i][j] == MAXV) continue;
                sum += distance[i][j];
            }
            if (min >= sum){
                min = sum;
                ans = i+1;
            }
        }
        System.out.println(ans);
    }
}

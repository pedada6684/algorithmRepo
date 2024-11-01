import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static final int maxv = 500*100000;
    static int[][] memo;
    static int[][] memo2;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            arr = new int[N+1];
            memo = new int[N][N];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) {
                arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < N; i++) {//끝점
                for (int s = 0 ; s+i < N; s++) {//시작점
                    int e = s+i;
                    memo[s][e] = maxv;
                    for (int m = 0; s+m < e; m++) {//divide
                        memo[s][e] = Math.min(memo[s][e], memo[s][s+m] + memo[s+m+1][e] + arr[e+1]-arr[s]);
                    }
                }
            }
            sb.append(memo[0][N-1]+"\n");
        }
        System.out.println(sb.toString().trim());
    }
}

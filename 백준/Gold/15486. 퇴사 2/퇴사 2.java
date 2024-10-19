import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static long[] memo;
    static int[][] arr;
    static final long maxv = 1500000*1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        memo = new long[N+1];
        Arrays.fill(memo, -1);
        memo[N] = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            arr[i] = new int[] {time, money};
        }
        for (int i = N-1; i >= 0; i--) {
            int time = arr[i][0];
            int money = arr[i][1];
            long doNot = i+1 < N+1? memo[i+1] : -1*maxv;
            long doWork = i+time < N+1 ? memo[i+time] : -1*maxv;
            memo[i] = Math.max(doNot, doWork+money);
        }

        System.out.println(memo[0]);
    }
}

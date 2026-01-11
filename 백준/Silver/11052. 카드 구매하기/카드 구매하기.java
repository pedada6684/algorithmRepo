import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int[] ans = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i+1] = Integer.parseInt(st.nextToken());
        }
        ans[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            int maxx = 0;
            for (int j = 1; j <= i/2; j++) {
                maxx = Math.max(maxx, ans[i-j]+ans[j]);
            }
            ans[i] = Math.max(arr[i], maxx);
        }
        System.out.println(ans[N]);
    }
}

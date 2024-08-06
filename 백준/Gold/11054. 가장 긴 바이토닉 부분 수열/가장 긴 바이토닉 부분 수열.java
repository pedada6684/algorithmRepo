import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        int[] dp1 = new int[N];
        Arrays.fill(dp1, 1);
        int[] dp2 = new int[N];
        Arrays.fill(dp2, 1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp1[i] = Math.max(dp1[i], dp1[j]+1);
                }
                if (nums[N-1-i] > nums[N-1-j]){
                    dp2[N-1-i] = Math.max(dp2[N-1-i], dp2[N-1-j]+1);
                }
            }
        }
        int ans = 1;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp1[i] + dp2[i]-1);
        }
        System.out.println(ans);
    }
}

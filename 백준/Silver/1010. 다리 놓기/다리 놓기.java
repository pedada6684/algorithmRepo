import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        test: for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            n = Math.min(n, m-n);
            long ans = 1;
            for (int i = 0; i < n; i++) {
                ans *= m-i;
            }
            for (int i = n; i > 0; i--) {
                ans /= i;
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString().trim());
    }
}
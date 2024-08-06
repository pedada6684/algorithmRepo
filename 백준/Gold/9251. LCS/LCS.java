import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String s2 = st.nextToken();

        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int ans = 0;

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                if (c1 == c2){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
                ans = Math.max(dp[i+1][j+1], ans);
            }
        }
        System.out.println(ans);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[][] houseColorPrice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        dp = new int[n][3];
        houseColorPrice = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            houseColorPrice[i][0] = Integer.parseInt(st.nextToken());
            houseColorPrice[i][1] = Integer.parseInt(st.nextToken());
            houseColorPrice[i][2] = Integer.parseInt(st.nextToken());
        }
        System.out.println(
                dp(0, -1)
        );
    }

    private static int dp(int idx, int priColor) {
        if (idx == dp.length){
            return 0;
        }if (idx != 0 && dp[idx][priColor] != 0){
            return dp[idx][priColor];
        }
        int[] colorPrice = new int[3];
        for (int i = 0; i < 3; i++) {
            colorPrice[i] = houseColorPrice[idx][i];
        }
        if (priColor != -1){
            colorPrice[priColor] = Integer.MAX_VALUE/2;
        }
        int result =
                Math.min(
                        dp(idx+1, 0) + colorPrice[0],
                Math.min(
                        dp(idx+1, 1) + colorPrice[1],
                        dp(idx+1, 2) + colorPrice[2]
                )
        );
        if (idx != 0){
            dp[idx][priColor] = result;
        }
        return result;
    }
}

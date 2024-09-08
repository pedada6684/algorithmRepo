import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int MAXSCORE = 4*100000;
    static List<Integer> command;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        command = new ArrayList<>();
        while (st.hasMoreTokens()){
            command.add(Integer.parseInt(st.nextToken()));
        }
        command.remove(command.size()-1);
        dp = new int[command.size()][5][5];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, MAXSCORE);
            }
        }
        int c = command.get(0);
        dp[0][c][0] = 2;
        System.out.println(dp(1, c, 0)+2);

//        for (int[] ints : dp[0]) {
//            for (int anInt : ints) {
//                System.out.print(anInt+ " ");
//            }
//            System.out.println();
//        }

    }

    private static int dp(int idx, int L, int R) {
//        System.out.println(idx+ " " +L+" "+R);
        if (idx == command.size()) return 0;
        if (dp[idx][L][R] != MAXSCORE) return dp[idx][L][R];
        if (L == R) return MAXSCORE;

        int c = command.get(idx);
        int resL = dp(idx+1, c, R) + calc(L,c);
        int resR = dp(idx+1, L, c) + calc(R,c);
        dp[idx][L][R] = Math.min(resR, resL);
        return dp[idx][L][R];
    }

    private static int calc(int now, int next) {
        if (now == 0) return 2;
        if (now == next) return 1;
        if (Math.max(now, next) - Math.min(now, next) == 2) return 4;
        return 3;
    }
}

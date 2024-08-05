import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
이 문제는 아주 평범한 배낭에 관한 문제이다.
한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다. 세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.
준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다.
아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.
 */
public class Main {
    static int[][] dp;
    static List<int[]> items;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        items = new ArrayList<>();
/*
입력
첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다. 두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.
입력으로 주어지는 모든 수는 정수이다.
 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[n][k+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            items.add(new int[] {w,v});
        }
        dp(k, 0);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < k+1; i++) {
            ans = Math.max(ans, dp[0][i]);
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[j][i]+" ");
//            }
//            System.out.println();
        }
        System.out.println(ans);
        /*
        출력
        한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력한다.
         */

    }

    private static int dp(int space, int i) {
        if (space < 0){
            return Integer.MIN_VALUE;
        } else if (i == dp.length) {
            return 0;
        } else if (space == 0) {
            return 0;
        } else if (dp[i][space] != 0){
            return dp[i][space];
        }
        int[] item = items.get(i);
        int result = Math.max(dp(space, i+1), dp(space-item[0], i+1)+item[1]);
        dp[i][space] = result;
        return result;
    }
}

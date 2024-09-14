import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer, City> cityMap;
    static double[][][] memo;
    static int N;
    static final int MAXV = 16*4000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        cityMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cityMap.put(i, new City(x,y,i));
        }
        memo = new double[N][N][(1<<N)];
        double ans = MAXV;
        for (int i = 0; i < N; i++) {
            ans = Math.min(ans, tsp(i, i, (1<<i)));
        }
        System.out.println(String.format("%.9f", ans));
    }

    private static double tsp(int now, int start, int state) {
        if (memo[start][now][state] != 0){
            return memo[start][now][state];
        }if (state == (1<<N)-1){
            return calcD(now, start);
        }
        double minD = MAXV;
        for (int i = 0; i < N; i++) {
            if ((state & 1<<i) == 0){
                minD = Math.min(minD, tsp(i, start, state | (1<<i)) + calcD(now, i));
            }
        }
        return memo[start][now][state] = minD;
    }

    private static double calcD(int a, int b) {
        City aC = cityMap.get(a);
        City bC = cityMap.get(b);
        double res = Math.pow((aC.x - bC.x), 2) + Math.pow((aC.y - bC.y), 2);
        return Math.sqrt(res);
    }


    private static class City {
        int x;
        int y;
        int num;

        public City(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}

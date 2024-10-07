import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static final BigInteger TWO = new BigInteger("2");
    static final BigInteger ONE = new BigInteger("1");
    static final int DIVIDER = 1_000_000_007;
    static Map<String, Long> memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger N = new BigInteger(st.nextToken());
        memo = new HashMap<>();
        memo.put("1", 1L);
        memo.put("2", 1L);
        long ans = dp(N);
        System.out.println(ans);
    }

    private static long dp(BigInteger n) {
        String nString = n.toString();
        if (memo.containsKey(nString)) return memo.get(nString);
        BigInteger half = n.divide(TWO);
        long fN = dp(half);
        long fN1 = dp(half.add(ONE));
        long res = 0;
        if (n.mod(TWO).intValue() == 1){
            res = fN1*fN1 + fN*fN;
        }else{
            long fNM1 = dp(half.subtract(ONE));
            res = fN1*fN + fN*fNM1;
        }
        res %= DIVIDER;
        memo.put(nString, res);
        return res;
    }
}
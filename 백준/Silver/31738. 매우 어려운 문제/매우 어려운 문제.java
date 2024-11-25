import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger N = new BigInteger(st.nextToken());
        BigInteger M = new BigInteger(st.nextToken());
        long ans = 0;
        if (N.compareTo(M) < 0){
            long n = N.longValue();
            long m = M.longValue();
            ans = 1;
            for (long i = 1; i <= n; i++) {
                ans = (ans*i)%m;
            }
        }
        System.out.println(ans);
    }
}
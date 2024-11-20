import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] isPrime = new boolean[4000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        int pcnt = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (!isPrime[i]) continue;
            pcnt++;
            int next = i*2;
            while (next < isPrime.length){
                isPrime[next] = false;
                next+= i;
            }
        }
        long[] sumArr = new long[pcnt+1];
        int sumIdx = 1;
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                sumArr[sumIdx] = sumArr[sumIdx-1] + i;
                sumIdx++;
            }
        }
        int N = Integer.parseInt(st.nextToken());
        int ans = 0;
        int s = 0;
        int e = 1;
        while (e < sumArr.length && sumArr[e]-sumArr[e-1] <= N){
            long now = sumArr[e] - sumArr[s];
            if (now == N){
                ans++;
                e++;
            }else if (now < N){
                e++;
            } else if (now > N) {
                s++;
            }
        }
        System.out.println(ans);
    }
}

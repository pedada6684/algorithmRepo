import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        BigInteger[] arr = new BigInteger[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = new BigInteger(st.nextToken());
        }
        Arrays.sort(arr);
        BigInteger ans = BigInteger.ZERO;
        int idx = N-1;
        if (N%2 != 0){
            ans = arr[N-1];
            N--;
            idx--;
        }
        while (idx >= N/2){
            BigInteger res = arr[idx].add(arr[N-1-idx]);
            ans = (ans.compareTo(res) < 0) ? res : ans;
            idx--;
        }
        System.out.println(ans);
    }
}
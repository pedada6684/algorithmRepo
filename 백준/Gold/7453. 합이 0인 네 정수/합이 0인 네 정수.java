import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N][4];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[] ab = new long[N*N];
        long[] cd = new long[N*N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ab[idx] = arr[i][0] + arr[j][1];
                cd[idx] = arr[i][2] + arr[j][3];
                idx++;
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);

        long ans = 0L;
        int left = 0;
        int right = cd.length - 1;

        while (left < ab.length && 0<= right) {
            Long a = ab[left];
            Long b = cd[right];
            long now = a + b;
            if (now == 0){
                int acnt = 0;
                while (left+acnt < ab.length && a == ab[left+acnt]){
                    acnt++;
                }
                int bcnt = 0;
                while (0 <= right-bcnt && b == cd[right-bcnt]){
                    bcnt++;
                }
                ans += (long) acnt * bcnt;
                left += acnt;
                right -= bcnt;
            } else if (now > 0) {
                right--;
            }else{
                left++;
            }
        }
        System.out.println(ans);
    }
}
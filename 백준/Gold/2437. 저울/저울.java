import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] sum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        sum[0] = 0;
        for (int i = 0; i < N; i++) {
            sum[i+1] = sum[i] + arr[i];
        }
        for (int i = 0; i < N; i++) {
            if (arr[i] > sum[i]+1){
                System.out.println(sum[i]+1);
                return;
            }
        }
        System.out.println(sum[N]+1);
    }
}
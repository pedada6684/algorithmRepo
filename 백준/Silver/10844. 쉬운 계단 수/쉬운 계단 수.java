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
        long[] arr = new long[10];
        Arrays.fill(arr, 1);
        arr[0] = 0;
        for (int i = 2; i <= N; i++) {
            long[] tmp = new long[10];
            for (int j = 0; j < arr.length; j++) {
                if(j == 0){
                    tmp[1] += arr[j];
                    tmp[1] %= 1000000000;
                }else if(j == 9){
                    tmp[8] += arr[j];
                    tmp[8] %= 1000000000;
                }else{
                    tmp[j-1] += arr[j];
                    tmp[j+1] += arr[j];
                    tmp[j-1] %= 1000000000;
                    tmp[j+1] %= 1000000000;
                }
            }
            arr = tmp.clone();

        }
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i];
            ans %= 1000000000;
        }
        System.out.println(ans);
    }
}

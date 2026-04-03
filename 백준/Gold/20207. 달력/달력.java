import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[367];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int j = s; j <= e; j++) {
                arr[j]++;
            }
        }

        int x = 0;
        int y = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                x++;
                y = Math.max(y, arr[i]);
            } else if(x != 0){
                ans += x*y;
                x = 0;
                y = 0;
            }
        }
        System.out.println(ans);
    }
}

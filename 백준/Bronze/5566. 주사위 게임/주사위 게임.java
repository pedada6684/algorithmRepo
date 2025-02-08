import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        int pos = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int dice = Integer.parseInt(st.nextToken());
            cnt++;
            pos += dice;
            if (pos >= arr.length) break;

            pos += arr[pos];
            if (pos >= arr.length) break;

        }
        System.out.println(cnt);
    }
}

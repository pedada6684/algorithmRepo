import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int ans = a*b;
        int[] arr = new int[5];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i-ans).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

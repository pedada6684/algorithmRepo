import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long a = 1;
        long b = 1;
        long tmp = 0;
        for (int i = 3; i <= N; i++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        System.out.println(b);
    }
}

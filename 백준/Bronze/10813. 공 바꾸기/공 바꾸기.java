import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] ball;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ball = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            ball[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == b)continue;
            ball[a] ^= ball[b];
            ball[b] ^= ball[a];
            ball[a] ^= ball[b];
        }
        for (int i = 1; i < ball.length; i++) {
            System.out.print(ball[i] +" ");
        }
    }
}
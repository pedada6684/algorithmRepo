import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[100][100];
        for (int paper = 0; paper < N; paper++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int i = x; i < x+10; i++) {
                for (int j = y; j < y+10; j++) {
                    map[i][j] = true;
                }
            }
        }
        int cnt = 0;
        for (boolean[] row : map) {
            for (boolean c : row) {
                if (c) cnt++;
            }
        }
        System.out.println(cnt);
    }
}

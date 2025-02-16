import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] ans = new int[5];
        char[][] map = new char[4*N+2+(N-1)][4*M+2+(M-1)];
        for (int i = 0; i < map.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        int x = 1;
        int y = 1;
        for (int i = 0; i < N; i++) {
            y = 1;
            for (int j = 0; j < M; j++) {
                int cnt = 0;
                int nx = x;
                while (map[nx][y] == '*'){
                    cnt++;
                    nx++;
                }
                ans[cnt]++;
                y += 5;
            }
            x += 5;
        }
        StringBuilder sb = new StringBuilder();
        for (int an : ans) {
            sb.append(an+" ");
        }
        System.out.println(sb.toString().trim());
    }
}

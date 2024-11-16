import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map.length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        memo = new int[N][N][3];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                for (int k = 0; k < memo[0][0].length; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        System.out.println(dp(0,1,0));
    }

    private static int dp(int x, int y, int shape) {
        if (x == memo.length-1 && y == memo.length-1){
            return 1;
        }if (memo[x][y][shape] != -1){
            return memo[x][y][shape];
        }
        int a = 0;
        int b = 0;
        int c = 0;
        int nx0 = x;
        int ny0 = y+1;
        int nx1 = x+1;
        int ny1 = y+1;
        int nx2 = x+1;
        int ny2 = y;
        boolean p0 = 0 <= nx0 && nx0 < map.length && 0<= ny0 && ny0 < map.length && map[nx0][ny0] == 0;
        boolean p1 =  0 <= nx1 && nx1 < map.length && 0<= ny1 && ny1 < map.length && map[nx1][ny1] == 0
                &&!(0 <= nx0 && nx0 < map.length && 0<= ny0 && ny0 < map.length && map[nx0][ny0] == 1)
                &&!(0 <= nx2 && nx2 < map.length && 0<= ny2 && ny2 < map.length && map[nx2][ny2] == 1);
        boolean p2 = 0 <= nx2 && nx2 < map.length && 0<= ny2 && ny2 < map.length && map[nx2][ny2] == 0;
        switch (shape){
            case 0: // -
                if (p0){
                    a = dp(nx0,ny0,0);
                }if (p1){
                    b = dp(nx1,ny1,1);
                }
                break;
            case 1: // \
                if (p0){
                    a = dp(nx0,ny0,0);
                }if (p1){
                    b = dp(nx1,ny1,1);
                }if (p2){
                    c = dp(nx2,ny2,2);
                }
                break;
            case 2: // |
                if (p1){
                    b = dp(nx1,ny1,1);
                }if (p2){
                    c = dp(nx2,ny2,2);
                }
                break;
        }
        return memo[x][y][shape] = a+b+c;
    }
}

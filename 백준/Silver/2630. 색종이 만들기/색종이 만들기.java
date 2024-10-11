import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int wpaper = 0;
    static int bpaper = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map.length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(map);
        System.out.println(wpaper);
        System.out.println(bpaper);
    }

    private static void recur(int[][] map) {
        if (isGood(map)){
            return;
        }
        recur(cut(map, 0));
        recur(cut(map, 1));
        recur(cut(map, 2));
        recur(cut(map, 3));
    }

    private static int[][] cut(int[][] map, int q) {
        int[][] sub = new int[map.length/2][map.length/2];
        int sx = 0;
        int sy = 0;
        switch (q){
            case 1:
                sx = map.length/2;
                sy = 0;
                break;
            case 2:
                sx = 0;
                sy = map.length/2;
                break;
            case 3:
                sx = map.length/2;
                sy = map.length/2;
                break;
        }
        for (int i = 0; i < map.length/2; i++) {
            for (int j = 0; j < map.length/2; j++) {
                sub[i][j] = map[sx+i][sy+j];
            }
        }
        return sub;
    }

    private static boolean isGood(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                cnt += map[i][j];
            }
        }
        if (cnt == 0) {
            wpaper++;
            return true;
        }
        if (cnt == map.length*map.length) {
            bpaper++;
            return true;
        }
        return false;
    }
}
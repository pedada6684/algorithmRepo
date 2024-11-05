import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] map;
    static int[] sel;
    static int ans;
    static int tmp;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        sel = new int[7];
        ans = 0;
        tmp = 0;
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        comb(0,0,0);

        System.out.println(ans);
    }

    private static void comb(int sidx, int pos, int ycnt) {
        if (ycnt > 3) return;
        if (sidx == sel.length){
            Set<Integer> set = new HashSet<>();
            for (int i : sel) set.add(i);

            boolean[][] v = new boolean[5][5];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{sel[0]/5, sel[0]%5});
            int length = 0;

            while (!q.isEmpty()){
                int x = q.peek()[0];
                int y = q.poll()[1];
                if (v[x][y]) continue;
                v[x][y] = true;
                length++;
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (0<=nx && nx<5 && 0<=ny && ny <5 && set.contains(nx*5+ny) && !v[nx][ny]){
                        q.add(new int[]{nx,ny});
                    }
                }
            }
            if (length == 7) {
                ans++;
            }
            return;
        }
        if (pos == 25) return;

        comb(sidx, pos+1, ycnt);
        sel[sidx] = pos;
        if (map[pos/5][pos%5] == 'Y') ycnt++;
        comb(sidx+1, pos+1, ycnt);
    }
}

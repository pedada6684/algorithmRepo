import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int[][] mapO;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int CORES;
    static int ANSWER;
    static List<Core> coreList;
    static int[] selectCoreList;


    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        test: for (int tc = 1; tc <= T; tc++) {
            CORES = 0;
            coreList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            mapO = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    mapO[i][j] = Integer.parseInt(st.nextToken());
                    if (mapO[i][j] == 1){
                        CORES++;
                        coreList.add(new Core(i,j));
                    }
                }
            }

            for (int i = CORES; i > 0 ; i--) {
                selectCoreList = new int[i];
                ANSWER = Integer.MAX_VALUE;
                superSet(0, 0);
                if (ANSWER != Integer.MAX_VALUE){
                    System.out.println("#"+tc+" "+ANSWER);
                    continue test;
                }
            }
        }
    }

    private static void superSet(int pidx, int sidx) {
        if (sidx == selectCoreList.length){
            //종료 후 탐색으로
            map = mapO.clone();
            dfs(0, 0);
            return;
        }
        for (int i = pidx; i < coreList.size(); i++) {
            selectCoreList[sidx] = i;
            superSet(i + 1, sidx + 1);
        }
    }

    private static void dfs(int now, int length) {
        if (now == selectCoreList.length){
            ANSWER = Math.min(ANSWER, length);
            return;
        }
        Core nowCore = coreList.get(selectCoreList[now]);
        if (nowCore.x == 0 || nowCore.x == map.length-1 || nowCore.y == 0 || nowCore.y == mapO.length-1 ){
            dfs(now+1, length);
            return;
        }
        for (int d = 0; d < 4; d++) {
            int x = nowCore.x;
            int y = nowCore.y;
            int addLength = 0;
            ArrayList<int[]> lineTracer = new ArrayList<>();
            x += dx[d];
            y += dy[d];
            while (x >= 0 && x < map.length && y >= 0 && y < mapO.length && map[x][y] == 0){// 뻗기
                map[x][y] = 8;
                addLength++;
                lineTracer.add(new int[]{x, y});
                if ( x == 0 || x == map.length-1 || y == 0 || y == mapO.length-1 ){
                    dfs(now+1, length+addLength);
                }
                x += dx[d];
                y += dy[d];
            }
            for (int[] target : lineTracer) {
                int rx = target[0];
                int ry = target[1];
                map[rx][ry] = 0;
            }
        }
    }


    private static void printMap(int[][] map) {
        for (int[] a : map) {
            for (int b: a) {
                System.out.print(b +" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static class Core {
        int x;
        int y;

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Core{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}

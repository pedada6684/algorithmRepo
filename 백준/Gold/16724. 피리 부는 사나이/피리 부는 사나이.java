import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] parent;
    static boolean[][] v;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Map<Integer, Boolean> group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        parent = new int[N][M];
        v = new boolean[N][M];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < M; j++) {
                parent[i][j] = cnt++;
                switch (s.charAt(j)){
                    case 'U':
                        map[i][j] = 0;
                        break;
                    case 'R':
                        map[i][j] = 1;
                        break;
                    case 'D':
                        map[i][j] = 2;
                        break;
                    case 'L':
                        map[i][j] = 3;
                        break;
                }
            }
        }

        group = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (parent[i][j] == M*i + j){ // 자기 자신인 경우 (첫 방문)
                    dfs(i,j);
                }
            }
        }
        System.out.println(group.size());
    }

    private static void dfs(int i, int j) {
        int d = map[i][j];
        int ni = i+dx[d];
        int nj = j+dy[d];
        int nextP = find(ni * M + nj);
        int nowP = find(i * M + j);
        if (nowP != nextP){
            if (group.containsKey(nextP)){ // union
                parent[nowP/M][nowP%M] = nextP;
            }else{ //new
                parent[ni][nj] = nowP;
                dfs(ni, nj);
            }
        }else{//사이클 완성
            group.put(nowP, true);
        }
    }

    private static int find(int n) {
        int i = n/M;
        int j = n%M;
        if (parent[i][j] != n){
            parent[i][j] = find(parent[i][j]);
        }
        return parent[i][j];
    }
}

/*


3 4
DLDD
DRLU
RRRU
 */
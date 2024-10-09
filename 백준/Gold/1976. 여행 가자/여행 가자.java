import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        boolean[][] link = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int c = Integer.parseInt(st.nextToken());
                if (c == 0) continue;
                link[i][j] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (link[i][j]){
                    union(i,j);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            find(i);
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken())-1;
        int p = find(m);
        for (int i = 1; i < M; i++) {
            m = Integer.parseInt(st.nextToken())-1;
            if (p != parent[m]){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int i, int j) {
        int to = Math.min(i,j);
        int from = Math.max(i,j);
        from = find(from);
        to = find(to);
        parent[from] = parent[to];
    }

    private static int find(int x) {
        if (parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}

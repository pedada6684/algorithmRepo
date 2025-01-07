import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] next, parent;
    static short[] v;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();
        int TC = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            next = new int[N];
            v = new short[N];
            parent = new int[N];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < next.length; i++) {
                next[i] = Integer.parseInt(st.nextToken())-1;
            }
            for (int i = 0; i < next.length; i++) {
                if (v[i] != 0) continue;
                flag = false;
                dfs(i, next[i]);
            }
            int cnt = 0;
            for (int i : v) {
                if (i != 1) cnt++;
            }
            ans.append(cnt+"\n");
        }
        System.out.println(ans.toString().trim());
    }

    private static void dfs(int from, int to) {
        if (v[to] != 0){
            v[from] = -1;
            flag = true;
            return;
        }
        if (parent[from] == parent[to]){
            makeGroup(to);
            flag = true;
            return;
        }
        parent[to] = parent[from];
        dfs(to, next[to]);
        if (flag && v[from] != 1) {
            v[from] = -1;
        }
    }

    private static void makeGroup(int now) {
        while (v[now] != 1){
            v[now] = 1;
            now = next[now];
        }
    }
}
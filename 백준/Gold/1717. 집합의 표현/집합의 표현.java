import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (o == 0){
                union(f,b);
            }else if (o == 1){
                int parentF = find(f);
                int parentB = find(b);
                if (parentB != parentF){
                    sb.append("NO\n");
                }else{
                    sb.append("YES\n");
                }
            }
        }
        System.out.println(sb.toString().trim());
    }

    private static void union(int f, int b) {
        int parentF = find(f);
        int parentB = find(b);
        if (parentB == parentF){
            return;
        }
        parent[parentF] = Math.min(parentB, parentF);
        parent[parentB] = Math.min(parentB, parentF);
    }

    private static int find(int c) {
        if (parent[c] == c){
            return c;
        }
        int ancestor = find(parent[c]);
        parent[c] = ancestor;
        return ancestor;
    }
}
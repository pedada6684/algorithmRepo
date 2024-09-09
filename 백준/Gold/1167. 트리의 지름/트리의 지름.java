import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, List<int[]>> relation;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        relation = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            List<int[]> listV = relation.getOrDefault(v, new ArrayList<>());
            while (st.hasMoreTokens()){
                int w = Integer.parseInt(st.nextToken());
                if (w == -1) break;
                int d = Integer.parseInt(st.nextToken());
                listV.add(new int[] {w,d});
            }
            relation.put(v, listV);
        }
        ans = 0;
        Node root = new Node(1, 0, new Node(0, 0, null));
        dfs(root);
        System.out.println(ans);
    }

    private static int dfs(Node now) {
        List<int[]> children = relation.get(now.value);
        int first = 0;
        int second = 0;
        for (int[] c : children) {
            if (c[0] == now.parent.value) continue;
            Node child = new Node(c[0], c[1]+now.distance, now);
            int childDistance = dfs(child);
            second = Math.max(second, childDistance);
            if (second > first){
                int tmp = first;
                first = second;
                second = tmp;
            }
        }
        if (first == 0) return now.distance;
        ans = Math.max(ans, first+second-2*now.distance);
        return first;
    }

    static class Node{
        int value;
        int distance;
        Node parent;

        public Node(int value, int distance, Node parent) {
            this.value = value;
            this.distance = distance;
            this.parent = parent;
        }
    }
}
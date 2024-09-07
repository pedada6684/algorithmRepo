import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int ans;
    static Map<Integer, List<int[]>> relation;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        relation = new HashMap<>();
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            List<int[]> parent = relation.getOrDefault(p, new ArrayList<>());
            parent.add(new int[] {c,d});
            relation.put(p,parent);
        }
        ans = 0;
        Node root = new Node(null, 1, 0);
        dfs(root);

        System.out.println(ans);

    }

    private static int dfs(Node parent) {
        List<int[]> ints = relation.get(parent.value);
        if (ints == null) {
            return parent.distance;
        }
        int first = 0;
        int second = 0;
        for (int[] arr : ints) {
            int c = arr[0];
            int d = arr[1] + parent.distance;
            Node child = new Node(parent, c, d);
            second = Math.max(second, dfs(child));
            if (second > first){
                int tmp = first;
                first = second;
                second = tmp;
            }

        }
        ans = Math.max(ans, first + second - 2* parent.distance);
        return first;
    }

    private static class Node {
        Node parent;
        int value;
        int distance;

        public Node(Node parent, int value, int distance) {
            this.parent = parent;
            this.value = value;
            this.distance = distance;
        }

    }
}


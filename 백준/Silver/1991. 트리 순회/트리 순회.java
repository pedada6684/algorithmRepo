import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Node root = new Node("A");
        Map<String, Node> map = new HashMap<>();
        map.put("A", root);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String p = st.nextToken();
            String l = st.nextToken();
            String r = st.nextToken();
            Node parent = map.getOrDefault(p, new Node(p));
            map.put(p, parent);
            if(!l.equals(".")) {
                parent.left = map.getOrDefault(l, new Node(l));
                map.put(l, parent.left);
            }
            if(!r.equals(".")) {
                parent.right = map.getOrDefault(r, new Node(r));
                map.put(r, parent.right);
            }
        }
        pre(root);
        sb.append("\n");
        mid(root);
        sb.append("\n");
        post(root);
        System.out.println(sb);
    }

    private static void post(Node root) {
        if (root == null) return;
        post(root.left);
        post(root.right);
        sb.append(root.name);
    }

    private static void mid(Node root) {
        if (root == null) return;
        mid(root.left);
        sb.append(root.name);
        mid(root.right);
    }

    private static void pre(Node root) {
        if (root == null) return;
        sb.append(root.name);
        pre(root.left);
        pre(root.right);
    }

    private static class Node {
        String name;
        Node left = null;
        Node right = null;

        public Node(String name) {
            this.name = name;
        }
    }
}

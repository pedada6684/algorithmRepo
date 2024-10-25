import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Node> root;
    static StringBuilder ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                sb.append(st.nextToken()+" ");
            }
            list.add(sb.toString().trim());
        }
        Collections.sort(list);
        root = new ArrayList<>();

        Node parent = makeRoot(list.get(0), null);

        for (int i = 1; i < list.size(); i++) {
            while (parent != null && !list.get(i).startsWith(parent.path+" ")){
                parent = parent.parent;
            }
            if (parent == null){
                parent = makeRoot(list.get(i), parent);
            }else{
                parent = makeRoot(list.get(i).substring(parent.path.length()), parent);
            }
        }
        ans = new StringBuilder();
        for (Node node : root) {
            print(node);
        }
        System.out.println(ans.toString().trim());
    }

    private static void print(Node now) {
        for (int i = 0; i < now.level; i++) {
            ans.append("--");
        }
        ans.append(now.value+"\n");
        for (Node child : now.children) {
            print(child);
        }
    }

    private static Node makeRoot(String s, Node parent) {
        String[] split = s.split(" ");
        if (parent == null){
            Node newRoot = new Node(split[0], null);
            root.add(newRoot);
            parent = newRoot;
        }
        for (int i = 1; i < split.length; i++) {
            String c = split[i];
            Node child = new Node(c, parent);
            parent.children.add(child);
            parent = child;
        }
        return parent;
    }

    private static class Node {
        int level;
        String value;
        String path;
        Node parent;
        List<Node> children = new ArrayList<>();

        public Node(String value, Node parent) {
            this.value = value;
            this.parent = parent;
            this.level = parent==null? 0 : parent.level+1;
            this.path = parent==null? value : parent.path+" "+value;
        }
    }
}
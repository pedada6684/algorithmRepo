import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, ArrayList<Integer>> relation;
    static Map<Integer, Node> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        relation = new HashMap<>();
        map = new HashMap<>();

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ArrayList<Integer> alist = relation.getOrDefault(a, new ArrayList<Integer>());
            ArrayList<Integer> blist = relation.getOrDefault(b, new ArrayList<Integer>());
            alist.add(b);
            blist.add(a);
            if (alist.size() == 1){
                relation.put(a, alist);
            }if (blist.size() == 1){
                relation.put(b, blist);
            }
        }

        Node root = new Node(R, null, 1);
        map.put(R, root);
        makeTree(root);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(map.get(Integer.parseInt(st.nextToken())).count+"\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static void makeTree(Node now) {
        ArrayList<Integer> child = relation.get(now.value);
        for (Integer c : child) {
            if (map.get(c) != null) continue;
            Node cNode = new Node(c, now, 1);
            map.put(c, cNode);
            makeTree(cNode);
            now.count += cNode.count;
        }
    }

    private static class Node {
        int value;
        Node parent;
        int count;

        public Node(int value, Node parent, int count) {
            this.value = value;
            this.parent = parent;
            this.count = count;
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        // 첫 번째 입력을 읽어 루트 노드 생성
        String input = br.readLine();
        Node root = new Node(Integer.parseInt(input));

        // 입력값이 더 이상 없을 때까지 트리를 생성
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int next = Integer.parseInt(input);
            makeTree(next, root);
        }
        dfs(root);
        System.out.println(sb.toString().trim());
    }

    private static void dfs(Node node) {
        if (node.left != null){
            dfs(node.left);
        }if (node.right != null){
            dfs(node.right);
        }
        sb.append(node.value+"\n");
    }

    private static void makeTree(int next, Node node) {
        if (node.value > next){
            if (node.left == null){
                node.left = new Node(next);
            }else{
                makeTree(next, node.left);
            }
        }else{
            if (node.right == null){
                node.right = new Node(next);
            }else{
                makeTree(next, node.right);
            }
        }
    }

    private static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}

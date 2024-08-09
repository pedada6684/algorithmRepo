import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String ans;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ans = "";
        nums = new int[N];
        Node[] dp = new Node[N];
        for (int i = 0; i < N; i++) {
            dp[i] = new Node(null, 1, i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int maxlen = 1;
        Node maxNode = dp[0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    if (dp[i].value < dp[j].value+1){
                        dp[i].parent = dp[j];
                        dp[i].value = dp[j].value+1;
                        dp[i].idx = i;
                        if (maxlen < dp[i].value){
                            maxlen = dp[i].value;
                            maxNode = dp[i];
                        }
                    }
                }
            }
        }
        dfs(maxNode);
        System.out.println(maxlen);
        System.out.println(ans.trim());
    }

    private static void dfs(Node now) {
        if (now.parent != null){
            dfs(now.parent);
        }
        ans += nums[now.idx]+" ";
    }

    public static class Node{
        Node parent;
        int value;
        int idx;

        public Node(Node parent, int value, int idx) {
            this.parent = parent;
            this.value = value;
            this.idx = idx;
        }
    }
}

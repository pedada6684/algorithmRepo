import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static String ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        ArrayList<Node> dp = new ArrayList<>();
        ans = "";

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        search: for (int input : nums) {
            if (dp.isEmpty()){
                dp.add(new Node(null, input));
            }else{
                if (dp.get(dp.size()-1).value < input){
                    dp.add(new Node(dp.get(dp.size()-1), input));
                }
                int start = 0;
                int end = dp.size();
                while (start != end){
                    int mid = (start + end)/2;
                    if (dp.get(mid).value < input){
                        start = mid + 1;
                    }else{
                        end = mid;
                    }
                }
                if (dp.get(end).value != input){
                    if (end == 0){
                        dp.set(end, new Node(null, input));
                    }else{
                        dp.set(end, new Node(dp.get(end-1), input));
                    }
                }
            }
        }
        System.out.println(dp.size());
        Node node = dp.get(dp.size() - 1);
        dfs(node);
        System.out.println(ans.trim());
    }

    private static void dfs(Node node) {
        if (node.parent != null){
            dfs(node.parent);
        }
        ans += node.value + " ";
    }

    public static class Node{
        Node parent;
        int value;

        public Node(Node parent, int value) {
            this.parent = parent;
            this.value = value;
        }
    }
}

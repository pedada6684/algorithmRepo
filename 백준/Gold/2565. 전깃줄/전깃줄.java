import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] nums;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        nums = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums, (a,b) -> a[0] == b[0]? a[1]-b[1] : a[0]-b[0]);
        ArrayList<Node> dp = new ArrayList();
        for (int i = 0; i < N; i++) {
            if (dp.isEmpty()){
                dp.add(new Node(null, nums[i][1], i));
                continue;
            }if (nums[i][1] > dp.get(dp.size()-1).value){
                dp.add(new Node( dp.get(dp.size()-1), nums[i][1], i));
                continue;
            }
            int minn = 0;
            int maxx = dp.size()-1;
            while (minn < maxx){
                int mid = (maxx + minn)/2;
                if (dp.get(mid).value < nums[i][1]){
                    minn = mid+1;
                }else{
                    maxx = mid;
                }
            }
            if (dp.get(maxx).value > nums[i][1]){
                if (maxx == 0){
                    dp.set(maxx, new Node(null, nums[i][1], i));
                }else{
                    dp.set(maxx, new Node(dp.get(maxx-1), nums[i][1], i));
                }
            }
        }
//        for (int i = 0; i < dp.size(); i++) {
//            System.out.print(dp.get(i).value+" ");
//        }
//        System.out.println();
//        dfs(dp.get(dp.size()-1));
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < N; i++) {
//            if (nums[i][0] != 0){
//                sb.append(nums[i][0]+"\n");
//            }
//        }

        System.out.println(N - dp.size());
//        System.out.println(sb.toString().trim());
    }

    private static void dfs(Node node) {
        nums[node.idx][0] = 0;
        if (node.parent != null){
            dfs(node.parent);
        }
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

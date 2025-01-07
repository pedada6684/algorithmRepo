import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, parent;
    static int[] v;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();
        int TC = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            v = new int[N];
            parent = new int[N];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken())-1;
            }
            for (int i = 0; i < arr.length; i++) {
                if (v[i] == 1) continue;
                flag = false;
                dfs(i, arr[i]);
            }
            int cnt = 0;
            for (int i : v) {
//                System.out.print(i+" ");
                if (i != 1) cnt++;
            }
//            System.out.println();
            ans.append(cnt+"\n");


        }
        System.out.println(ans.toString().trim());
    }

    private static void dfs(int from, int to) {
//        System.out.println("from : "+from +" to: "+to);
        if (v[to] != 0){
//            System.out.println("fail: "+from);
            v[from] = -1;
            flag = true;
            return;
        }
//        System.out.println("==from : "+from +" to: "+to);
        if (parent[from] == parent[to]){
//            System.out.println("makeGroup "+to);
            makeGroup(to);
            flag = true;
            return;
        }
        parent[to] = parent[from];
        dfs(to, arr[to]);
        if (flag && v[from] != 1) {
//            System.out.println("fail: "+from);
            v[from] = -1;
        }
    }

    private static void makeGroup(int to) {
//        System.out.println("start: "+to);
        while (v[to] != 1){
            v[to] = 1;
            to = arr[to];
//            System.out.println("next: "+to);
        }
//        System.out.println("==========");
    }
}
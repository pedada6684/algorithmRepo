import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[N];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            union(a,b);
        }

        for (int i = 0; i < N; i++) {
            find(i);
        }

        int[] arr = new int[N];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            arr[parent[i]] = Math.min(cost[i], arr[parent[i]]);
        }

        int samt = 0;

        for (int i = 0; i < N; i++) {
            if(arr[i] != Integer.MAX_VALUE) samt += arr[i];
        }

        if(samt > K){
            System.out.println("Oh no");
        }else{
            System.out.println(samt);
        }
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        parent[pb] = pa;
    }

    private static int find(int a) {
        if(parent[a] != a){
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
}

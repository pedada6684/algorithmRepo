import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<String, Integer> memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[][] command = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            command[i] = new int[] {a,b,cost};
        }
        int[] ans = arr.clone();
        Arrays.sort(ans);
        memo = new HashMap<>();
        PriorityQueue<State> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
        State first = new State(arr, 0);
        pq.add(first);

        while (!pq.isEmpty()){
            State now = pq.poll();
            if (!isGood(now)) continue;
            if (Arrays.toString(ans).equals(now.toString())){
                System.out.println(now.cost);
                return;
            }
            for (int[] c : command) {
                pq.add(now.swap(c));
            }
        }
        System.out.println(-1);
    }

    private static boolean isGood(State now) {
        if (memo.containsKey(now.toString())){
            Integer memoCost = memo.get(now.toString());
            if (memoCost <= now.cost) return false;
        }
        memo.put(now.toString(), now.cost);
        return true;
    }

    private static class State {
        int[] arr;
        int cost;
        public State(int[] arr, int c) {
            this.arr = arr.clone();
            cost = c;
        }

        @Override
        public String toString() {
            return Arrays.toString(arr);
        }

        public State swap(int[] c) {
            State newState = new State(arr, cost+c[2]);
            int[] newArr = newState.arr;
            int tmp = newArr[c[0]];
            newArr[c[0]] = newArr[c[1]];
            newArr[c[1]] = tmp;
            return newState;
        }
    }
}

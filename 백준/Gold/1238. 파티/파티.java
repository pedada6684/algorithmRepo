import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAXV = 100*1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        Map<Integer, List<int[]>> goMap = new HashMap<>();
        Map<Integer, List<int[]>> comeMap = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            List<int[]> goEdges = goMap.getOrDefault(s, new ArrayList<>());
            goEdges.add(new int[] {e,d});
            goMap.put(s, goEdges);

            List<int[]> comeEdges = comeMap.getOrDefault(e, new ArrayList<>());
            comeEdges.add(new int[] {s,d});
            comeMap.put(e,comeEdges);
        }
        int[] goDistance = new int[N+1];
        Arrays.fill(goDistance, MAXV);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{X,0});
        while (!pq.isEmpty()){
            int e = pq.peek()[0];
            int d = pq.poll()[1];
            if (d < goDistance[e]){
                goDistance[e] = d;
                List<int[]> edges = goMap.get(e);
                for (int[] edge : edges) {
                    if (goDistance[edge[0]] < d + edge[1]) continue;
                    pq.add(new int[] {edge[0], d+edge[1]});
                }
            }
        }

        int[] comeDistance = new int[N+1];
        Arrays.fill(comeDistance, MAXV);
        pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{X,0});
        while (!pq.isEmpty()){
            int e = pq.peek()[0];
            int d = pq.poll()[1];
            if (d < comeDistance[e]){
                comeDistance[e] = d;
                List<int[]> edges = comeMap.get(e);
                for (int[] edge : edges) {
                    if (comeDistance[edge[0]] < d + edge[1]) continue;
                    pq.add(new int[] {edge[0], d+edge[1]});
                }
            }
        }

        int maxD = 0;
        for (int i = 1; i < N+1; i++) {
            maxD = Math.max(maxD, goDistance[i] + comeDistance[i]);
        }
        System.out.println(maxD);
    }
}

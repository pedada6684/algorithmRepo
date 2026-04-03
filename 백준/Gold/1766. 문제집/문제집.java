import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] linkCnt = new int[N+1];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            List<Integer> aLink = map.getOrDefault(a, new ArrayList<>());
            aLink.add(b);
            linkCnt[b]++;
            map.put(a, aLink);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        for (int i = 1; i <= N; i++) {
            if (linkCnt[i] == 0){
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()){
            Integer poll = pq.poll();
            sb.append(poll+" ");
            List<Integer> link = map.get(poll);
            if(link != null){
                for (Integer i : link) {
                    linkCnt[i]--;
                    if(linkCnt[i] == 0){
                        pq.add(i);
                    }
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}

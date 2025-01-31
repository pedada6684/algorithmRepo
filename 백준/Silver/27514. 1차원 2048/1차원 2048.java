import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long l = Long.parseLong(st.nextToken());
            if (l == 0L) continue;
            Long cnt = map.getOrDefault(l, 0L);
            map.put(l, cnt+1);
        }
        Long ans = 0L;
        PriorityQueue<Long[]> pq = new PriorityQueue<>(Comparator.comparing((Long[] a) -> a[0]));
        for (Long k : map.keySet()) {
            pq.add(new Long[]{k, map.get(k)});
            ans = Math.max(ans, k);
        }
        while (!pq.isEmpty()){
            Long[] poll = pq.poll();
            Long now = poll[0];
            Long cnt = poll[1];
            if (cnt < 2) continue;
            Long next = 2*now;
            cnt /= 2;
            if (!pq.isEmpty() && pq.peek()[0].equals(next)){
                cnt += pq.poll()[1];
            }
            pq.add(new Long[]{next, cnt});
            ans = Math.max(ans, next);
        }
        System.out.println(ans);
    }
}

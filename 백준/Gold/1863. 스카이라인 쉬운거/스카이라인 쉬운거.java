import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
		pq.add(0);
		int ans = 0;

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			Integer.parseInt(st.nextToken());
			int nowH = Integer.parseInt(st.nextToken());

			while (nowH < pq.peek()){
				pq.poll();
			}
			if (nowH == pq.peek()) continue;
			if (nowH > pq.peek()) {
				ans++;
				pq.add(nowH);
			}
		}
		System.out.println(ans);
	}
}
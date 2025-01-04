import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int now = 64;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(64);
        while (now != N){
            Integer poll = pq.poll();
            int half = poll/2;
            now -= half;
            if (now < N){
                now += half;
                pq.add(half);
            }
            pq.add(half);
        }
        System.out.println(pq.size());
    }
}

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
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Math.abs(a) != Math.abs(b)? Math.abs(a)-Math.abs(b) : a-b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if (x == 0){
                if (!pq.isEmpty()) sb.append(pq.poll()+"\n");
                else sb.append(0+"\n");
            }else{
                pq.add(x);
            }
        }
        System.out.println(sb.toString().trim());

    }
}

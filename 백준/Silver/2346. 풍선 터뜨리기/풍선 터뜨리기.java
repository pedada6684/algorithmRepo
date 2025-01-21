import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Deque<int[]> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int step = Integer.parseInt(st.nextToken());
            q.add(new int[]{i+1, step});
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()){
            int[] poll = q.poll();
            sb.append(poll[0]+" ");
            if (q.isEmpty()) break;
            if (poll[1] > 0) poll[1]--;
            int move = poll[1]%q.size();
            if (move < 0){
                for (int i = move; i < 0; i++) {
                    q.addFirst(q.pollLast());
                }
            }else{
                for (int i = 0; i < move; i++) {
                    q.add(q.poll());
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}
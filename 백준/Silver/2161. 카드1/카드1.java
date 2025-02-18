import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            q.add(i+1);
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()){
            sb.append(q.poll()+" ");
            if (!q.isEmpty()){
                q.add(q.poll());
            }
        }
        System.out.println(sb.toString().trim());
    }
}

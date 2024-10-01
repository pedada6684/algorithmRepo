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
        Deque<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")){
                q.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                if (q.isEmpty()) sb.append(-1+"\n");
                else sb.append(q.poll()+"\n");
            } else if (command.equals("size")) {
                sb.append(q.size()+"\n");
            } else if (command.equals("empty")) {
                if (q.isEmpty()) sb.append(1+"\n");
                else sb.append(0+"\n");
            } else if (command.equals("front")) {
                if (q.isEmpty()) sb.append(-1+"\n");
                else sb.append(q.peek()+"\n");
            } else if (command.equals("back")) {
                if (q.isEmpty()) sb.append(-1+"\n");
                else sb.append(q.peekLast()+"\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}

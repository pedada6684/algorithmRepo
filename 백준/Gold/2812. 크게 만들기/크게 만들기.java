import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int OK = Integer.parseInt(st.nextToken());
        int K = OK;
        String s = br.readLine();
        arr = new int[N];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int x = s.charAt(i) - '0';
                while (!dq.isEmpty() && dq.getLast() < x && K > 0){
                    dq.pollLast();
                    K--;
                }
                dq.addLast(x);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N-OK; i++) {
            sb.append(dq.pollFirst());
        }
        System.out.println(sb.toString().trim());
    }
}
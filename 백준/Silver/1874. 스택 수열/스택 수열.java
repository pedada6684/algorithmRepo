import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        int now = 1;
        for (int i = 0; i < N; i++) {
            while (stack.isEmpty() || arr[i] > stack.peek()){
                stack.push(now++);
                sb.append("+\n");
            }
            if (arr[i] == stack.peek()){
                stack.pop();
                sb.append("-\n");
            }else{
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }
        }
        System.out.println(sb.toString().trim());

    }
}

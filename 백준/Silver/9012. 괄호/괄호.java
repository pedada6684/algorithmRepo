import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        LOOP1: for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c=='('){
                    stack.push(c);
                }else if (stack.isEmpty() || stack.peek() != '('){
                    System.out.println("NO");
                    continue LOOP1;
                }else{
                    stack.pop();
                }
            }
            if (stack.isEmpty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}

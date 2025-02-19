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
        int[] arr = new int[N];
        String cmd = br.readLine();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < cmd.length(); i++) {
            char c = cmd.charAt(i);
            if ('A' <= c && c <= 'Z'){
                stack.add(arr[c-'A']+0.0);
            }else{
                Double b = stack.pop();
                Double f = stack.pop();
                switch (c){
                    case '*':
                        stack.push(f*b);
                    break;
                    case '/':
                        stack.push(f/b);
                    break;
                    case '+':
                        stack.push(f+b);
                    break;
                    case '-':
                        stack.push(f-b);
                    break;
                }
            }
        }
        System.out.println(String.format("%.2f", stack.pop()));
    }
}
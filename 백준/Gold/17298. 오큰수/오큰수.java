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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> s = new Stack<>();
        int[] res = new int[N];
        for (int i = N-1; i >= 0 ; i--) {
            while (!s.isEmpty() && s.peek() <= arr[i]){
                s.pop();
            }if (s.isEmpty()) {
                res[i] = -1;
            }else{
                res[i] = s.peek();
            }
            s.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int r : res) {
            sb.append(r+" ");
        }
        System.out.println(sb.toString().trim());
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[i] = new int[] {a,b};
            }
            Arrays.sort(arr, Comparator.comparing(a -> a[0]));
            Stack<Integer> stack = new Stack<>();
            stack.push(arr[0][1]);
            for (int[] i : arr) {
                if (stack.peek()>i[1]) stack.push(i[1]);
            }
            sb.append(stack.size()+"\n");
        }
        System.out.println(sb.toString().trim());
    }
}
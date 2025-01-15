import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            left.push(s.charAt(i));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken().charAt(0)){
                case 'L':
                   if (!left.isEmpty()){
                       right.push(left.pop());
                   }
                    break;
                case 'D':
                    if (!right.isEmpty()){
                        left.push(right.pop());
                    }
                    break;
                case 'B':
                    if (!left.isEmpty()) left.pop();
                    break;
                case 'P':
                   left.push(st.nextToken().charAt(0));
                    break;
            }
        }
        StringBuilder sbl = new StringBuilder();
        StringBuilder sbr = new StringBuilder();
        left.forEach(sbl::append);
        right.forEach(sbr::append);
        System.out.println(sbl.toString()+sbr.reverse().toString());
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TC; i++) {
            String s = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                switch (c){
                    case '<':
                        if (!left.isEmpty()){
                            right.push(left.pop());
                        }
                        break;
                    case '>':
                        if (!right.isEmpty()){
                            left.push(right.pop());
                        }
                        break;
                    case '-':
                        if (!left.isEmpty()){
                            left.pop();
                        }
                        break;
                    default:
                        left.push(c);
                }

            }
            StringBuilder tmp = new StringBuilder();
            while (!left.isEmpty()) tmp.append(left.pop());
            sb.append(tmp.reverse());
            while (!right.isEmpty()) sb.append(right.pop());
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}

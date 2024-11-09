import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        char pri =  ' ';
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                stack.push(c);
            }else if (pri == '('){ //lazer
                stack.pop();
                ans += stack.size();
            }else{
                stack.pop();
                ans +=1;
            }
            pri = c;
        }
        System.out.println(ans);
    }
}
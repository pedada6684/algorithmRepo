import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack;
        StringBuilder sb = new StringBuilder();
        while (!s.equals(".")){
            stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '['){
                    stack.push(c);
                }else if (c == ')'){
                    if (!stack.isEmpty()&&stack.peek() == '(') stack.pop();
                    else{
                        sb.append("no\n");
                        break;
                    }
                }else if (c == ']'){
                    if (!stack.isEmpty()&&stack.peek() == '[') stack.pop();
                    else{
                        sb.append("no\n");
                        break;
                    }
                }
                if (i == s.length()-1){
                    if (stack.isEmpty()){
                        sb.append("yes\n");
                    }else{
                        sb.append("no\n");
                    }
                }

            }
            s = br.readLine();
        }
        System.out.println(sb.toString().trim());
    }
}
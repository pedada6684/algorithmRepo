import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('(', 4);
        priority.put('*', 3);
        priority.put('/', 3);
        priority.put('+', 2);
        priority.put('-', 2);
        priority.put(')', 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
//            System.out.println("now: "+ now);
            if (priority.containsKey(now)){ // 부호
                if (stack.isEmpty()){
                    stack.push(now);
                }else{
                    if (now == '('){
                        stack.add(now);
                    }else if (now == ')'){
                        while (stack.peek() != '('){
                            sb.append(stack.pop());
                        }
                        stack.pop();
                    }else{
                        while (!stack.isEmpty()
                                && priority.get(stack.peek()) >= priority.get(now)
                                && stack.peek() != '(') { //스택이 우선순위가 높은 경우
                            sb.append(stack.pop());
                        }
                        stack.add(now);
                    }
                }
            }else{
//                System.out.println("now: "+ now);
                sb.append(now);
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static final int LIMIT = 1_000_000_009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        long ans = 1;
        char pri = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'd'){
                ans *= c == pri? 9 : 10;
            }else{
                ans *= c == pri? 25 : 26;
            }
            ans %= LIMIT;
            pri = c;
        }
        System.out.println(ans);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String ans = "";
        int max = Integer.MIN_VALUE;;
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int m = Integer.parseInt(st.nextToken());
            if (max <= m){
                max = m;
                ans = s;
            }
        }
        System.out.println(ans);
    }
}

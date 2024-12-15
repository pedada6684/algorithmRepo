import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        char[] hint = new char[N];
        String[] arr = new String[M];
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            hint[i] = s.charAt(i);
        }
        for (int i = 0; i < M; i++) {
            arr[i] = br.readLine();
        }

        for (String string : arr) {
            int hi = 0;
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (hint[hi] == c){
                    hi++;
                    if (hi == hint.length) break;
                }
            }
            if (hi == hint.length) sb.append("true");
            else sb.append("false");
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}

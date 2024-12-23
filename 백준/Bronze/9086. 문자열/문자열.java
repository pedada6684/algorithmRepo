import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            sb.append(s.charAt(0));
            sb.append(s.charAt(s.length()-1));
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-i-1; j++) {
                sb.append(" ");
            }
            sb.append("*");
            for (int j = 0; j < 2*i-1; j++) {
                sb.append(" ");
            }
            if (i != 0){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
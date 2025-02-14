import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long ans = (N*N + N)/2 ;
        System.out.println(ans);
        System.out.println(ans*ans);
        System.out.println(ans*ans);
    }
}

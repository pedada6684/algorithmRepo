import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        String[] split = s.split("[^2]+");
        long score = 0;
        for (String string : split) {
            long l = string.length();
            score += l*(l+1)*(l+2)/6;
        }
        System.out.println(score);
    }
}
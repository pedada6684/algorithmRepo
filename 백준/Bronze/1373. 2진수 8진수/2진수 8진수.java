import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int i = str.length() % 3;
        int s = 0;
        int e = i%3 == 0 ? 3 : i%3;
        while (s < str.length()){
            String ss = str.substring(s, e);
            sb.append(Integer.parseInt(ss,2));
            s = e;
            e = s+3;
        }
        System.out.println(sb);
    }
}

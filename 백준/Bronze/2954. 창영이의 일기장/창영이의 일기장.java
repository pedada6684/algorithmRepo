import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i<s.length()){
            sb.append(s.charAt(i));
            switch (s.charAt(i)){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    i += 3;
                    break;
                default:
                    i++;
            }
        }
        System.out.println(sb.toString());
    }
}

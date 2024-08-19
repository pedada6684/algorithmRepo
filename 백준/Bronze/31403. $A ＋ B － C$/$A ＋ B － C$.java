import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        int aa = Integer.parseInt(a);

        st = new StringTokenizer(br.readLine());
        String b = st.nextToken();
        int bb = Integer.parseInt(b);

        st = new StringTokenizer(br.readLine());
        String c = st.nextToken();
        int cc = Integer.parseInt(c);

        System.out.println(aa+bb-cc);
        System.out.println(Integer.parseInt(a+b) - cc);
    }
}

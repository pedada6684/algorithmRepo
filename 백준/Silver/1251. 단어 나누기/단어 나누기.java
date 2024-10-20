import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        List<String> list = new ArrayList<>();

        for (int i = 1; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                StringBuilder sb = new StringBuilder()
                        .append(new StringBuilder(s.substring(0,i)).reverse().toString())
                        .append(new StringBuilder(s.substring(i,j)).reverse().toString())
                        .append(new StringBuilder(s.substring(j,s.length())).reverse().toString());
                list.add(sb.toString());
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}

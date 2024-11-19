import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];
        String start = "";
        String end = "";
        for (int i = 0; i < N + 1; i++) {
            String s = br.readLine();
            if (i == 0){
                String[] split = s.split("\\*");
                start = split[0];
                end = split[1];
            }else{
                arr[i-1] = s;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            if (s.startsWith(start) && s.endsWith(end) && start.length() + end.length() <= s.length()){
                sb.append("DA\n");
            }else{
                sb.append("NE\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}

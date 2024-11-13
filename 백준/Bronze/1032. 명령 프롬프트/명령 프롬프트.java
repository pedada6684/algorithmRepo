import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        char[] ans = new char[arr[0].length()];
        loop1: for (int i = 0; i < arr[0].length(); i++) {
            char c = arr[0].charAt(i);
            for (int j = 1; j < arr.length; j++) {
                if (c != arr[j].charAt(i)){
                    ans[i] = '?';
                    continue loop1;
                }
            }
            ans[i] = c;
        }
        System.out.println(new StringBuilder().append(ans));
    }
}

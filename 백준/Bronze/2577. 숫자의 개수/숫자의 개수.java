import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[10];
        Integer res = a * b * c;
        String string = res.toString();
        for (int i = 0; i < string.length(); i++) {
            int num = string.charAt(i) - '0';
            arr[num]++;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}

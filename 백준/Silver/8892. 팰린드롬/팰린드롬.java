import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(st.nextToken());
        test: for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String[] arr = new String[N];
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine();
            }
            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    if (isPalin(arr[i]+arr[j])){
                        sb.append(arr[i]+arr[j]+"\n");
                        continue test;
                    }if (isPalin(arr[j]+arr[i])){
                        sb.append(arr[j]+arr[i]+"\n");
                        continue test;
                    }
                }
            }
            sb.append(0+"\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static boolean isPalin(String s) {
        for (int i = 0; i < s.length()/2+1; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
}

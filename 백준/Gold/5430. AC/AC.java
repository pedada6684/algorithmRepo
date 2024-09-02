import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        TestCase: for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), "[], ");
            String[] arr = new String[n];
            for (int j = 0; j < n; j++) {
                arr[j] = st.nextToken();
            }
            int start = 0;
            int end = arr.length-1;
            int direction = 1;
            for (int j = 0; j < command.length(); j++) {
                char c = command.charAt(j);
//                System.out.println(c+" "+" "+start+" "+end);
                switch (c){
                    case 'R':
                        direction *= -1;
                        break;
                    case 'D':
                        if (start>end){
                            sb.append("error\n");
                            continue TestCase;
                        }
                        if (direction == 1){
                            start++;
                        }else{
                            end--;
                        }
                        break;
                }
            }

            if (start>end){
                sb.append("[]\n");
            }else{
                sb.append("[");
                if (direction == -1){
                    for (int j = end; j >= start  ; j--) {
                        sb.append(arr[j]+",");
                    }
                }else{
                    for (int j = start; j <= end ; j++) {
                        sb.append(arr[j]+",");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append("]"+"\n");
            }

        }
        System.out.println(sb.toString().trim());
    }
}
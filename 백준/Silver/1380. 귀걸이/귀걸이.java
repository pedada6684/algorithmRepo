import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int scene = 1;
        while (true){
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            String[] arr = new String[N];
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine();
            }
            Map<String, Boolean> map = new HashMap<>();
            for (int i = 0; i < 2*N-1; i++) {
                int num = Integer.parseInt(br.readLine().split(" ")[0])-1;
                String g = arr[num];
                if (map.containsKey(g)){
                    map.remove(g);
                }else{
                    map.put(g, true);
                }
            }
            sb.append(scene+" "+map.keySet().stream().collect(Collectors.toList()).get(0)).append("\n");
            scene++;
        }
        System.out.println(sb.toString().trim());
    }
}

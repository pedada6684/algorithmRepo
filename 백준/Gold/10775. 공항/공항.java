import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    static Map<Integer, District> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int G = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        
        map = new HashMap<>();
        parent = new int[G+1];
        
        int[] plane = new int[P];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            plane[i] = Integer.parseInt(st.nextToken());
            set.add(plane[i]);
        }
        List<Integer> sortedPlane = new ArrayList<>(set);
        Collections.sort(sortedPlane);

        int pidx = 1;
        for (int i = 0; i < sortedPlane.size(); i++) {
            Integer sp = sortedPlane.get(i);
            while (pidx < G+1 && pidx <= sp){
                parent[pidx++] = sp;
            }
            int prior = i == 0 ? 0 : sortedPlane.get(i-1);
            map.put(sp, new District(sp, prior));
        }
        
        int cnt = 0;
        for (int p : plane) {
            District district = map.get(find(p));
            if (!district.parking()) break;
            cnt++;
        }
        System.out.println(cnt);
    }
    
    private static int find(int p) {
        if (parent[p] != p){
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    private static class District {
        int bottom;
        int idx;
        int head;

        public District(int parent, int bottom) {
            this.head = parent;
            this.idx = parent;
            this.bottom = bottom;
        }

        public boolean parking() {
            if (idx < 1) return false;
            if (bottom < idx){
                idx--;
                return true;
            }else{
                parent[find(head)] = find(bottom);
                District district = map.get(parent[find(head)]);
                return district.parking();
            }
        }
    }
}

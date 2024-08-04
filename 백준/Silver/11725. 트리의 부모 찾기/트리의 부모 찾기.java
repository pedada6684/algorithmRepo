import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Map<Integer, Integer> tree = new HashMap<>();
        Map<Integer, Set<Integer>> connectMap = new HashMap<>();
        tree.put(1, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Set<Integer> set1 = connectMap.getOrDefault(f, new HashSet<>());
            set1.add(b);
            if (set1.size()==1){
                connectMap.put(f, set1);
            }
            Set<Integer> set2 = connectMap.getOrDefault(b, new HashSet<>());
            set2.add(f);
            if (set2.size()==1){
                connectMap.put(b, set2);
            }
        }

        makeTree(1, connectMap, tree);

        List<Integer> nodelist = new ArrayList<>(tree.keySet());
        nodelist.sort((x,y) -> {return x-y;});
        for (Integer num: nodelist) {
            if (num == 1) continue;
            System.out.println(tree.get(num));
        }
    }

    private static void makeTree(int parent, Map<Integer, Set<Integer>> connectMap, Map<Integer, Integer> tree) {
        Set<Integer> connect = connectMap.get(parent);
        if (connect == null){
            return;
        }
        for (Integer node: connect) {
            if (tree.containsKey(node)){
                continue;
            }
            tree.put(node, parent);
            makeTree(node, connectMap, tree);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Node> map = new HashMap<>();
        Node main = new Node("main");
        map.put("main", main);

        List<String> createFile = new ArrayList<>();

        for (int i = 0; i < N+M; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");

            String path1 = split[0];
            String path2 = split[1];
            String path3 = split[2];
            if(path3.equals("1")){

                Node parent = map.getOrDefault(path1, new Node(path1));
                Node child = map.getOrDefault(path2, new Node(path2));
                child.setParent(parent);
                parent.addChildren(child);
                map.put(path1, parent);
                map.put(path2, child);
            }else{
                createFile.add(s);
            }
        }

        for (String s : createFile) {
            String[] split = s.split(" ");

            String path1 = split[0];
            String path2 = split[1];

            Node folder = map.get(path1);
            folder.files.add(path2);
            folder.fileCnt++;
        }

        dfs(main);

        st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            String s = br.readLine();
            String[] split = s.split("/");
            String f = split[split.length - 1];

            Node now = map.get(f);
            sb.append(now.files.size()+" "+now.fileCnt+"\n");
        }

        System.out.println(sb.toString().trim());

    }

    private static void dfs(Node p) {
        List<Node> children = p.children;
        if(!children.isEmpty()){
            for (Node child : children) {
                dfs(child);
                p.fileCnt += child.fileCnt;
                p.files.addAll(child.files);
            }
        }
    }

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        int fileCnt = 0;
        Set<String> files = new HashSet<>();
        Node parent = null;

        Node(String name){
            this.name = name;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        void addChildren(Node c){
            this.children.add(c);
        }

    }
}

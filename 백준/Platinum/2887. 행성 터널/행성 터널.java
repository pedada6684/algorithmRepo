import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        parent = new int[N];
        Planet[] planetArr = new Planet[N];
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planetArr[i] = new Planet(i, x,y,z);
            parent[i] = i;
        }
        Arrays.sort(planetArr, (a,b) -> a.x - b.x);
        for (int i = 0; i < N-1; i++) {
            Planet aP = planetArr[i];
            Planet bP = planetArr[i+1];
            edges.add(new Edge(aP.value, bP.value, Math.abs(aP.x-bP.x)));
            edges.add(new Edge(bP.value, aP.value, Math.abs(aP.x-bP.x)));
        }
        Arrays.sort(planetArr, (a,b) -> a.y - b.y);
        for (int i = 0; i < N-1; i++) {
            Planet aP = planetArr[i];
            Planet bP = planetArr[i+1];
            edges.add(new Edge(aP.value, bP.value, Math.abs(aP.y-bP.y)));
            edges.add(new Edge(bP.value, aP.value, Math.abs(aP.y-bP.y)));
        }
        Arrays.sort(planetArr, (a,b) -> a.z - b.z);
        for (int i = 0; i < N-1; i++) {
            Planet aP = planetArr[i];
            Planet bP = planetArr[i+1];
            edges.add(new Edge(aP.value, bP.value, Math.abs(aP.z-bP.z)));
            edges.add(new Edge(bP.value, aP.value, Math.abs(aP.z-bP.z)));
        }
        edges.sort((a,b) -> a.d -b.d);
        int ans = 0;
        for (Edge edge : edges) {
            int s = edge.s;
            int e = edge.e;
            int parentS = find(s);
            int parentE = find(e);
            if (parentS != parentE){
                parent[parentE] = parentS;
                ans += edge.d;
            }
        }
        System.out.println(ans);
    }


    private static int find(int n) {
        if (parent[n] != n){
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    private static class Planet {
        int value;
        int x,y,z;

        public Planet(int value, int x, int y, int z) {
            this.value = value;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static class Edge {
        int s, e, d;

        public Edge(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }
    }
}

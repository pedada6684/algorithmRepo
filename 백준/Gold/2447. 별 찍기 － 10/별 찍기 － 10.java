import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        divide(0,0,N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static void divide(int x, int y, int size) {
        if (size == 3){
            for (int i = x; i < x+3; i++) {
                for (int j = y; j < y+3; j++) {
                    if (i == x+1 && j == y+1) map[i][j] = ' ';
                    else map[i][j] = '*';
                }
            }
            return;
        }
        int nextSize = size/3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nx = x+nextSize*i;
                int ny = y+nextSize*j;
                if (i == 1 && j == 1){
                    makeBlank(nx, ny, nextSize);
                }else{
                    divide(nx, ny, nextSize);
                }
            }
        }
    }

    private static void makeBlank(int nx, int ny, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[nx+i][ny+j] = ' ';
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] priceTable;
    static int[][][] dpTable;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        priceTable = new int[N][3];
        dpTable = new int[3][N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            priceTable[i][0] = Integer.parseInt(st.nextToken());
            priceTable[i][1] = Integer.parseInt(st.nextToken());
            priceTable[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            //초항 설정
            for (int j = 0; j < 3; j++) {
                if (j != i){
                    dpTable[i][0][j] = 5000;
                }else{
                    dpTable[i][0][j] = priceTable[0][j];
                }
            }
            //점화식 시작
            for (int j = 1; j < N; j++) {
                for (int k = 0; k < 3; k++) {
                    switch (k){
                        case 0:
                            dpTable[i][j][k] = Math.min(dpTable[i][j-1][1], dpTable[i][j-1][2]) + priceTable[j][k];
                            break;
                        case 1:
                            dpTable[i][j][k] = Math.min(dpTable[i][j-1][0], dpTable[i][j-1][2]) + priceTable[j][k];
                            break;
                        case 2:
                            dpTable[i][j][k] = Math.min(dpTable[i][j-1][1], dpTable[i][j-1][0]) + priceTable[j][k];
                            break;
                    }
                }
            }
            dpTable[i][N-1][i] = Integer.MAX_VALUE;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ans = Math.min(dpTable[i][N-1][j], ans);
            }
        }
        System.out.println(ans);
    }
}

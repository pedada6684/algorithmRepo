import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        int[] arr4 = new int[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr1[i]   = Integer.parseInt(st.nextToken());
            arr2[i]   = Integer.parseInt(st.nextToken());
            arr3[i]   = Integer.parseInt(st.nextToken());
            arr4[i]   = Integer.parseInt(st.nextToken());
        }

        int[] arr12 = new int[n*n];
        int[] arr34 = new int[n*n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr12[i*n+j] = arr1[i] + arr2[j];
                arr34[i*n+j] = arr3[i] + arr4[j];
            }
        }

        Arrays.sort(arr12);
        Arrays.sort(arr34);

        long cnt = 0;
        int left = 0;
        int right = n*n-1;
        while(left < n*n && right >= 0){
            int sum = arr12[left] + arr34[right];

            if(sum == 0){
                int a = arr12[left];
                int b = arr34[right];

                int aCnt = 0, bCnt = 0;
                while(left < n*n && arr12[left] == a) {
                    aCnt++;
                    left++;
                }
                while(right >= 0 && arr34[right] == b){
                    bCnt++;
                    right--;
                }

                cnt += (long)aCnt * bCnt;
            } else if(sum > 0){
                right--;
            } else{
                left++;
            }
        }

        System.out.println(cnt);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l1 = br.readLine().length();
        int l2 = br.readLine().length();
        System.out.println(l1 >= l2? "go":"no");
    }
}

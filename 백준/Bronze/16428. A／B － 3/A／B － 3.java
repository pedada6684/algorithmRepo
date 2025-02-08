import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());
        BigInteger div = a.divide(b);
        BigInteger mod = a.remainder(b);
        if (mod.compareTo(BigInteger.ZERO)<0){
            mod = mod.add(b.abs());
            if (b.compareTo(BigInteger.ZERO) < 0) {
                div = div.add(BigInteger.ONE);
            }else{
                div = div.subtract(BigInteger.ONE);
            }
        }
        System.out.println(div);
        System.out.println(mod);
    }
}

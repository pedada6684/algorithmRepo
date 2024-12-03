import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] occur;
    static List<Long> list;
    static Set<Long> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long ON = Long.parseLong(st.nextToken())+1L;
        long N = ON;
        long x = 2L;

        List<Integer> primes = new ArrayList<>();
        boolean[] notPrimes = new boolean[(int)Math.sqrt(ON)+1];
        for (int i = 2; i < notPrimes.length; i++) {
            if (!notPrimes[i]){
                int next = i+i;
                while (next < notPrimes.length){
                    notPrimes[next] = true;
                    next += i;
                }
                primes.add(i);
            }
        }

        list = new ArrayList<>();
        int pidx = 0;
        while (pidx < primes.size() && N != 1){
            Integer p = primes.get(pidx);
            if (N%p == 0){
                list.add((long)p);
                N /= p;
                pidx = 0;
            }else{
                pidx++;
            }
        }
        if (N != 1){
            list.add(N);
        }
        occur = new boolean[list.size()];
        set = new HashSet<>();
        powerSet(0);
        List<Long> ans = new ArrayList<>(set);
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (Long an : ans) {
            if (an == ON) continue;
            sb.append(an+" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void powerSet(int sidx) {
        if (sidx == list.size()){
            long ans = 1L;
            for (int i = 0; i < occur.length; i++) {
                if (occur[i]){
                    ans *= list.get(i);
                }
            }
            set.add(ans);
            return;
        }
        powerSet(sidx+1);
        occur[sidx] = true;
        powerSet(sidx+1);
        occur[sidx] = false;
    }
}


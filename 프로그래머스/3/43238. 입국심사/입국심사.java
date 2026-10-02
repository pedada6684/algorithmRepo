class Solution {

    static int N;
    static int[] A;

    public long solution(int n, int[] times) {

        N = n;
        A = times;

        long answer = 0;
        long s = 1;

        long e = (long) times[0] * n;

        while (s <= e) {

            long m = s + (e - s) / 2;

            if (check(m)) {
                answer = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return answer;
    }

    public boolean check(long t) {

        long res = 0;

        for (int time : A) {
            res += t / time;

            if (res >= N) {
                return true;
            }
        }

        return false;
    }
}
public class Prime {
    public static void main(String[] args) {
        long time0 = System.currentTimeMillis();

        int[] primes = calculatePrimes(20000);

        long time1 = System.currentTimeMillis();

        printPrimes(primes);

        long time2 = System.currentTimeMillis();

        System.out.printf("\nCalculate: %.1fs, Print: %.1fs\n", (time1 - time0) / 1000.0f, (time2 - time1) / 1000.0f);
    }

    public static int[] calculatePrimes(int n) {
        int[] prime = new int[n];
        boolean[] visit = new boolean[n + 1];

        for (int i = 2; i <= n; ++i) {
            if (!visit[i]) {
                prime[++prime[0]] = i;
            }

            for (int j = 1; j <= prime[0] && i * prime[j] <= n; ++j) {
                visit[i * prime[j]] = true;

                if (i % prime[j] == 0) {
                    break;
                }
            }
        }

        return prime;
    }

    public static void printPrimes(int[] primes) {
        for (int i = 1; i < primes.length && primes[i] != 0; ++i) {
            System.out.print(primes[i]);
            System.out.print(i % 5 == 0 ? '\n' : '\t');
        }
    }
}
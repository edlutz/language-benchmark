import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Primes {

    private long[] primes;

    public Primes(long[] prs) {
        primes = prs;
    }
    
    public static void main(String[] args) {
        if (args.length<1) {
            return;
        }
        int size = Integer.parseInt(args[0]);
        long[] prs = new long[size];
        Primes p = new Primes(prs);
        ThreadMXBean tb = ManagementFactory.getThreadMXBean();
        long t1 = tb.getCurrentThreadCpuTime();
        p.fill();
        long t2 = tb.getCurrentThreadCpuTime();
        long dt = (t2-t1)/1000000;
        System.out.println(String.format("CPU time spent: %d ms", dt));
        System.out.println(String.format("Number of elements: %d", p.getSize()));
        System.out.println(String.format("Last prime: %d", p.getPrime(p.getSize()-1)));
    }



    public void fill() {
        int np = primes.length;
        primes[0] = 2;
        int n = 1;
        long p = 3;
        while (n < np) {
            boolean isPrime = true;
            int j = 0;
            long last = primes[0];
            while ((isPrime) && (last * last < p)) {
                if ((p % last) == 0) {
                    isPrime = false;
                } else {
                    last = primes[++j];
                }
            }
            if (isPrime) {
                primes[n++] = p;
            }
            p += 2;
        }
    }

    public int getSize() {
        return primes.length;
    }

    public long getPrime(int index) {
        return primes[index];
    }
}

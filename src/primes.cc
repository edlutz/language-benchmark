#include <stdio.h>
#include <stdlib.h>
#include <time.h>


#define TRUE 1
#define FALSE 0
#define BOOLEAN int



class Primes {

public:

  long *primes;
  int np;

  Primes(long *primesBuffer, int n) {
    if ((primes==NULL) || (n<2)) {
      primes = new long[2];
      n = 2;
    }
    primes = primesBuffer;
    np = n;
  }


  void fill() {
    primes[0] = 2;
    int n = 1;
    long p = 3;
    while (n<np) {
      BOOLEAN isPrime = TRUE;
      int j = 0;
      long last = primes[0];
      while ((isPrime) && (last*last<p)) {
	if ((p % last)==0) isPrime = FALSE;
	else {
	  last = primes[++j];
	}
      }
      if (isPrime) primes[n++] = p;
      p += 2;
    }
  }

};




int main(int argc, char * argv[]) {
  if (argc<2) exit(0);
  int size;
  sscanf(argv[1], "%d", &size);
  long *prs = (long *) malloc(size*sizeof(long));
  Primes p(prs, size);
  clock_t t1 = clock();
  p.fill();
  clock_t t2 = clock();
  long dt = (long) ((t2-t1)/1000);
  printf("Elapsed time: %ld ms\n", dt);
  printf("Number of elements: %d\n", size);
  printf("Last prime: %ld\n", p.primes[p.np-1]);

  return 0;
}

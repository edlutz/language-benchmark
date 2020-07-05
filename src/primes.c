#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define TRUE 1
#define FALSE 0
#define BOOLEAN int

long *primes;
int np;

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

int main(int argc, char *argv[]) {
	if (argc<2) {
		return 1;
	}
	sscanf(argv[1], "%d", &np);
	primes = (long*) malloc(sizeof(long)*np);
	clock_t t1 = clock();
	fill();
	clock_t t2 = clock();
	long dt = (long) ((t2-t1)/1000);
	printf("CPU time spent: %ld ms\n", dt);
	printf("Number of elements: %d\n", np);
	printf("Last prime: %ld\n", primes[np-1]);
	free(primes);
	return 0;
}

#!/usr/bin/python

import time
import sys

__author__="ed"
__date__ ="$Mar 3, 2009 8:55:22 AM$"

class Primes:
    primes = []
    length = 10;
    
    def __init__(self, prs):
    	self.primes = prs
    	self.length = len(prs)

    def fill(self):
        np = self.length
        self.primes[0] = 2
        n = 1
        p = 3
        try:
            while n<np:
                isPrime = 1
                j = 0
                last = self.primes[0]
                while isPrime and last*last<p:
                    if p % last == 0:
                        isPrime = 0
                    else:
                        j += 1
                        last = self.primes[j]
                if isPrime:
                    self.primes[n] = p
                    n += 1
                p += 2
        except (IndexError):
            print "Error on index %s" % n


    def getSize(self):
        return len(self.primes)

    def getPrime(self, index):
        return self.primes[index]

if __name__ == "__main__":
    if len(sys.argv)<2:
        print "Argument: number of primes to compute"
    else:
        size = int(sys.argv[1])
        prs = range(0, size);
        p = Primes(prs)
        t1 = time.time()
        p.fill()
        t2 = time.time()
        dt = t2-t1
        print "Time spent: %s s" % dt
        print "Number of elements: %s" % p.getSize()
        print "Last prime: %s" % p.getPrime(p.getSize()-1)

        

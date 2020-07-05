class Primes

  def initialize
    @primes = []
  end

  def fill(np)
    @primes << 2
    n = 1
    p = 3
    begin
      while n<np
        isPrime = true
        j = 0
        last = @primes[0]
        while isPrime and last*last<p
          if p % last == 0
            isPrime = false
          else
            j += 1
            last = @primes[j]
          end
        end
        if isPrime
          @primes[n] = p
          n += 1
        end
        p += 2
      end
    rescue
      puts "Error on index %s" % n
    end
  end

  def getSize
    @primes.length
  end

  def getPrime(index)
    @primes[index]
  end

end

if ARGV.length<1
  puts "Argument: number of primes to compute"
else
  size = ARGV[0].to_i
  p = Primes.new
  t1 = Time.new.to_i
  p.fill(size)
  t2 = Time.new.to_i
  dt = t2-t1
  puts "Time spent: %s s" % dt
  puts "Number of elements: %s" % p.getSize
  puts "Last prime: %s" % p.getPrime(p.getSize-1)
end


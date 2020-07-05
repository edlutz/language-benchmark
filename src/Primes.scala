class Worker(buffer: Array[Long]) {
  
  var primes: Array[Long] = buffer
  
  def getSize(): Int = primes.size
  
  def getPrime(index: Int): Long = primes(index)
  
  def fill() : Unit = {
    var np: Int = primes.length
    primes(0) = 2
    var n : Int = 1
    var p : Long = 3
    while (n < np) {
      var isPrime : Boolean = true
      var j : Int = 0
      var last : Long = primes(0)
      while ((isPrime) && (last * last < p)) {
        if ((p % last) == 0) {
          isPrime = false
        } else {
          j += 1
          last = primes(j)
        }
      }
      if (isPrime) {
        primes(n) = p
        n += 1
      }
      p += 2
    }
  }
  
}

object Primes {
  def main(args: Array[String]) : Unit = {
    if (args.size<1) {
      return
    }
    var size : Int = args(0).toInt
    var prs : Array[Long] = new Array[Long](size)
    var worker : Worker = new Worker(prs)
    var t1 : Long = System.currentTimeMillis()
    worker.fill()
    var t2 : Long = System.currentTimeMillis()
    var dt : Long = t2-t1
    println("CPU time spent: %d ms".format(dt))
    println("Number of elements: %d".format(size))
    println("Last prime: %d".format(prs(size-1)))
  }
}

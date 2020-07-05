package main

import (
  "fmt"
  "os"
  "strconv"
  "time"
)

func main() {
  if len(os.Args)<1 {
    return
  }
  size,_ := strconv.ParseInt(os.Args[1], 10, 0)
  var primes = make([]int64, size)
  t1 := time.Now()
  fill(primes)
  t2 := time.Now()
  d1 := convertTime(t1)
  d2 := convertTime(t2)
  fmt.Printf("Time spent: %v\n", d2-d1)
  fmt.Printf("Number of elements: %v\n", size)
  fmt.Printf("Last prime: %v\n", primes[size-1])
}

func convertTime(t time.Time) float64 {
  ns := float64(t.Nanosecond())/1e9
  return float64((t.Hour()*60+t.Minute())*60+t.Second())+ns
}

func fill(primes []int64) {
  var np int = len(primes)
  primes[0] = 2
  var n int = 1
  var p int64 = 3
  for n<np {
    var isPrime bool = true
    var j int = 0
    var last int64 = primes[0]
    for isPrime && (last*last<p) {
      if p%last == 0 {
        isPrime = false
      } else {
        j++
        last = primes[j]
      }
    }
    if isPrime {
      primes[n] = p
      n++
    }
    p += 2
  }
}


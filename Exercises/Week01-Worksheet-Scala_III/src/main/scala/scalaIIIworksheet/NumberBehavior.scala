package scalaIIIworksheet

import scala.collection.mutable.ArrayBuffer

/**
  * Created by nathanhanak on 1/29/17.
  */
object NumberBehavior {

  def isPrime(n: Int): Boolean = {
    for (i <- 2 to n-1; if n%i == 0 ) {
    return false
    }
    true
  }

  def isHappy(n: Int): Boolean = {
    var k = n
    isHappy(n: Int, k : Int)
  }

  def isHappy(original: Int, alteredN: Int): Boolean = {
    var newN = squareAndSumDigits(alteredN)
    if (newN != original && newN != 1) isHappy(original, newN) else (newN == 1)
  }

  def squareAndSumDigits(n : Int): Int = {
    val allDigits = singleOutDigits(n)
    (for(elem <- allDigits) yield elem*elem).sum
  }

  def singleOutDigits(n : Int): ArrayBuffer[Int] = {
    var buf = ArrayBuffer[Int]()
    var j = n
    while (j != 0 ) {
      val i = j % 10
      buf += i
      j = j/10
    }
    buf
  }


  def isTriangular(n: Int): Boolean = {
    n match {
      case n if n < 1 => false
      case _ => evaluator(n, 1, (counter: Int) => counter + 1 )
    }
  }

  def evaluator(j:Int, counter:Int, f1:(Int) => (Int)): Boolean = (j, counter) match {
    case _ if j-counter == 0 => true
    case _ if j-counter < 0 => false
    case _ => evaluator(j-counter, f1(counter), f1)
  }

  def isSquare(n : Int): Boolean = {
    n match {
      case _ if n < 1 => throw new IllegalArgumentException ("Cannot be 0 or negative")
      case _ => evaluator(n, 1, (counter:Int) => counter + 2)
    }
  }

  def isSmug(n: Int): Boolean = {
    var j = 1
    while ( (n-(j*j)) > (j*j) ) {
        j += 1
    }
    var l = j*j
    var r = n - l
    if (isSquare(l) && isSquare(r)) true else false
  }

  def isHonest(n: Int): Boolean = {
    var k = 1
    while (n/k != k || n/k > k) {
      k += 1
    }
    if (n/k == k && k*k == n) true else false
  }

  def isPronic(n: Int): Boolean = {
    var i = 1
    while ( i*(i+1) < n  ) {
      i += 1
    }
    if (n == (i*(i+1)) ) true else false
  }

  // def isDeficient(n: Int): Boolean
  // def isPerfect(n: Int): Boolean
  // def isAbundant(n: Int): Boolean

}

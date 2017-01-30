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


  // def isTriangular(n: Int): Boolean
  // def isSquare(n: Int): Boolean
  // def isSmug(n: Int): Boolean
  // def isHonest(n: Int): Boolean
  // def isPronic(n: Int): Boolean
  // def isDeficient(n: Int): Boolean
  // def isPerfect(n: Int): Boolean
  // def isAbundant(n: Int): Boolean

}

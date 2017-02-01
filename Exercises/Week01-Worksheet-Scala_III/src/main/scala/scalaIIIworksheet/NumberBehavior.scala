package scalaIIIworksheet

import scala.collection.mutable.ArrayBuffer

/**
  * Created by nathanhanak on 1/29/17.
  */
object NumberBehavior {

  def main(args: Array[String]): Unit = {
    println("Enter a positive integer as a limit to get number behaviors")
    var limit : Int = scala.io.StdIn.readInt()
    while (limit < 0) {
      println("You entered a negative integer, please try again")
      limit = scala.io.StdIn.readInt()
    }

    var result = ""
    var i = 1
    for ( i <- 1 to limit ) {
      result = i.toString + "   "
      if (isPrime(i)) result += "p, " else result += "c, "
      if (isHappy(i)) result += "h, " else result += "u, "
      if (isTriangular(i)) result += "t, "
      if (isSquare(i)) result += "s, "
      if (isSmug(i)) result += "sm, "
      if (isHonest(i)) result += "ht, " else result += "dis, "
      if (isPronic(i)) result +="pr, "
      if (isDeficient(i)) result +="d, "
      if (isPerfect(i)) result +="per" else result += "abun"
      println(result)
      println
    }
  }

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
      case n if n < 1 => throw new IllegalArgumentException (s"Cannot be 0 or negative. You passed $n")
      case n => evaluator(n, 1, (counter:Int) => counter + 2)
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

  def isDeficient(n: Int): Boolean = {
    sumOfPositiveDivisorsOf(n) < n
  }

  def isPerfect(n: Int): Boolean = {
    sumOfPositiveDivisorsOf(n) == n
  }

  def isAbundant(n: Int): Boolean = {
    sumOfPositiveDivisorsOf(n) > n
  }

  def sumOfPositiveDivisorsOf(n:Int): Int = {
    var result = 0
    for ( i <- 1 to n-1 if (n%i==0) ) {
      result += i
    }
    result
  }

}

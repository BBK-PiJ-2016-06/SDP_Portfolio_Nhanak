package scalaIIIworksheet

import org.scalatest.FunSuite
import scalaIIIworksheet.NumberBehavior._

/**
  * Created by nathanhanak on 1/29/17.
  */
class NumberBehaviorTest extends FunSuite {

  test("isPrime returns true if number is true, false if not") {
    assert(isPrime(3) == true)
    assert(isPrime(13) == true)
    assert(isPrime(8) == false)
    assert(isPrime(240) == false)
  }

  test("isHappy returns true if Number is true, false if not") {
    assert(isHappy(19) == true, "19 is Happy")
    assert(isHappy(4) == false, "4 is not Happy")
  }

  test("isTriangular returns true if Number if triangular, false if not") {
    assert(isTriangular(15) == true, "15 is triangular")
    assert(isTriangular(12) == false, "12 is not triangular")
  }

  test("isSquare returns true if a number is square") {
    assert(isSquare(16) == true, ": isSquare(16) should return true")
    assert(isSquare(25) == true, ": isSquare(16) should return true")
    assert(isSquare(17) == false, ": isSquare(17) should return false")
    assert(isSquare(999) == false, ": isSquare(999) should return false")
  }

  test("isSmug returns true if a number is smug") {
    assert(isSmug(5) == true, ": isSmug(5) should return true")
    assert(isSmug(10) == true, ": isSmug(10) should return true")
    assert(isSmug(13) == true, ": isSmug(5) should return true")
    assert(isSmug(6) == false, ": isSmug(6) should return false")
    assert(isSmug(12) == false, ": isSmug(12) should return false")
  }

  test("isHonest returns true if a number/k = k AND k*k = n"){
    assert(isHonest(16) == true, ": is Honest(16) should return true")
    assert(isHonest(9) == true, ": is Honest(9) should return true")
    assert(isHonest(5) == false, ": is Honest(5) should return false")
  }

  test("isPronic returns true if a number can be the product of two consecutive numbers") {
    assert(isPronic(6) == true, ": isPronic(6) should return true")
    assert(isPronic(20) == true, ": isPronic(20) should return true")
    assert(isPronic(5) == false, ": isPronic(5) should return false")
    assert(isPronic(11) == false, ": isPronic(11) should return false")
  }




}

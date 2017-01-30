package scalaIIIworksheet

import org.scalatest.FunSuite
import scalaIIIworksheet.NumberBehavior._

/**
  * Created by nathanhanak on 1/29/17.
  */
class NumberBehaviorTest extends FunSuite {

  test("isPrime returns true if number is true, false if not") {
    assert(isPrime(3) == true )
    assert(isPrime(13) == true)
    assert(isPrime(8) == false)
    assert(isPrime(240) == false)
  }

  test("isHappy returns true if Number is true, false if not") {
    assert(isHappy(19) == true, "19 is Happy")
    assert(isHappy(4) == false, "4 is not Happy")
  }



}

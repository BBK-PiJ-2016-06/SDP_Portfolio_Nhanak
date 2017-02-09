package question1

import org.scalatest.FunSuite

/**
  * Created by nathanhanak on 2/9/17.
  */
class Question1Test extends FunSuite {

  test("Calling inc with a parameter increases as expected") {
    assert(new Counter(4).inc(3).count == 7)
  }

  test("Calling dec with a parameter increases as expected") {
    assert(new Counter(4).dec(2).count == 2)
  }

  test("Calling inc with no parameter increases count by 1 ") {
    assert(new Counter(5).inc().count == 6)
  }

  test("Calling dec with no parameter decreases count by 1") {
    assert(new Counter(5).dec().count == 4)
  }

  test("For CounterAsCase Calling inc with a parameter increases as expected") {
    assert(new CounterAsCase(4).inc(3).count == 7)
  }

  test("For CounterAsCase Calling dec with a parameter increases as expected") {
    assert(new CounterAsCase(4).dec(2).count == 2)
  }

  test("For CounterAsCase Calling inc with no parameter increases count by 1 ") {
    assert(new CounterAsCase(5).inc().count == 6)
  }

  test("For CounterAsCase Calling dec with no parameter decreases count by 1") {
    assert(new CounterAsCase(5).dec().count == 4)
  }

  test("Calling adjust with an int adds the int to count's total") {
    assert(new Counter(5).adjust(new Adder(3)).count == 8)
  }
  
}

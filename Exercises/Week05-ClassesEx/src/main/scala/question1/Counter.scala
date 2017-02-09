package question1

/**
  * Created by nathanhanak on 2/9/17.
  */
class Counter(val count : Int) {

  def inc(n: Int = 1): Counter = new Counter(count+n)

  def dec(n: Int = 1): Counter = new Counter(count-n)

  def adjust(a : Adder): Counter = {
    new Counter(a.add(count))
  }

}

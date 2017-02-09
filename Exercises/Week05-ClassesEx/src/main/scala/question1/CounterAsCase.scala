package question1

/**
  * Created by Nathan Hanak on 2/9/17.
  */
case class CounterAsCase(count : Int = 0) {

  def inc(n: Int = 1): CounterAsCase = CounterAsCase(count+n)

  def dec(n: Int = 1): CounterAsCase = CounterAsCase(count-n)

}

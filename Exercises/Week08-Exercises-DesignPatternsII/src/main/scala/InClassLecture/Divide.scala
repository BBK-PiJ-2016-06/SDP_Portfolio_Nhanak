package InClassLecture

import java.util.Optional

/**
  * Created by nathanhanak on 2/28/17.
  */
object Divide extends App {

  def divide(numerator: Int, denominator: Int): Option[Double] = {
    if(denominator == 0) None else Some(numerator.toDouble/denominator.toDouble)
  }
  
  def divideOptions(numerator: Option[Int], denominator: Option[Int]): Option[Double] = {
    for {
      a <- numerator // takes numerator out of its box and appends it to a
      b <- denominator // takes denominator out of its box and appends it to b
      c <- divide(a,b) // normal int stuff
    } yield c
  }


  println(divide(1,0))
  println(divide(1,2))
  println(divide(0,3))

  println(divideOptions(Some(1),Some(0)))
  println(divideOptions(Some(1),Some(2)))
  println(divideOptions(Some(0),Some(3)))

}

// when the denominator is 0 it doesn't throw an exception but uses Option

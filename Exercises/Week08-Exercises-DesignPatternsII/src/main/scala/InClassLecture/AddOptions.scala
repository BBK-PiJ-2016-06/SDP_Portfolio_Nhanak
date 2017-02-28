package InClassLecture

/**
  * Created by nathanhanak on 2/28/17.
  */
object AddOptions extends App {


  //accepts three Option[Int] as formal parameters and returns their sum
  // Version One - use flatMap and Map
  // Version Two - use for comprehensions
  def addOptionsWithMap(opt1: Option[Int], opt2: Option[Int], opt3: Option[Int]): Option[Int] = {
    opt1 flatMap { a => // flatMap takes the value of opt1 out of its "optional" box
      opt2 flatMap { b => // ditto
        opt3 map { c => // map takes the Option out of its box, and the righthand function then does the computation
          a + b + c
        }
      }
    }
  }

  def addOptionsWithForComp(opt1: Option[Int], opt2: Option[Int], opt3: Option[Int]): Option[Int] = {
    for {
      a <- opt1 //extracts the Int from the Option box
      b <- opt2 // ditto
      c <- opt3 // ditto
    } yield a + b + c // does the computation, and wraps it back in to an Option due to the return type
  }

}

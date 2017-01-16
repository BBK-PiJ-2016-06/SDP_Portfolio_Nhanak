import scala.math._
import scala.io.StdIn.{readLine, readInt}

object WorkSheet_I_For_Loop {

  def main (args: Array[String]): Unit = {

    //"Use a while loop"
    var i = 1

    while(i != 0) {
      println("Enter a number")
      i = readInt()
      if (i !=0) {
        println( s"You entered: ${i} and its square is: ${i*i}")
      }
    }
    //"Use a for loop"

    var k = 1

    for (k <- 1 to 25) {
      println("k= " + k + ", k sq = " + (k*k) + ", k to the pow 3 = " + pow(k, 3))
    }


  }
}
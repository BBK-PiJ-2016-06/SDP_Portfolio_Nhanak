println("2+ 2 = " + (2+2) )

println("13 squared = " + (13*13) )

def isEven(number:Int): Boolean = {
  return (number % 2 == 0)
}

println("12 is even? " + isEven(12))
println("How about 27? " + isEven(number = 27))

/*

when loading directly in to REPL - no need to use def main (args   ....
import scala.math._


object test {

  def main (args: Array[String]): Unit ={

    println("2+ 2 = " + (2+2) )

    println("13 squared = " + pow(13, 2))

  }
}

*/
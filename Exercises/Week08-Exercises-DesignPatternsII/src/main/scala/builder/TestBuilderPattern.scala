package builder

object TestBuilderPattern {
  def main(args: Array[String]) {
    var carBuilder: CarBuilder = SedanCarBuilder
    var director: CarDirector = CarDirector(carBuilder)

    director.build
    println(carBuilder.getCar)

    carBuilder = SportsCarBuilder
    director = CarDirector(carBuilder)

    director.build
    println(carBuilder.getCar)
  }
}

/*
Make a specific carBuilder
    Make a Cardirector containing said carBuilder
      tell the director to build a car
*/
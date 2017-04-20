package builder

case class CarDirector(carBuilder: CarBuilder) {

  def build: Unit = {
    carBuilder.buildBodyStyle
    carBuilder.buildPower
    carBuilder.buildEngine
    carBuilder.buildBreaks
    carBuilder.buildSeats
    carBuilder.buildWindows
    carBuilder.buildFuelType
  }

  def getCar: Car = carBuilder.getCar

}

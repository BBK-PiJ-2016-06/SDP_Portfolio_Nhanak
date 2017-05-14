package decorator

class SimplyNonVegPizza extends Pizza {

  var description = "Pizza Type Non-Veg: "
  val price = 9.99

  def getDesc: String = {
    return description
  }

  def getPrice: Double = {
    return price
  }
}

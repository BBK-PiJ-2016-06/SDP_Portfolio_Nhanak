package decorator

class SimplyVegPizza extends Pizza {

  val desc = "Pizza type Veggies: "
  val price = 10.99

  def getDesc: String = {
    return desc
  }

  def getPrice: Double = {
    return price
  }

}

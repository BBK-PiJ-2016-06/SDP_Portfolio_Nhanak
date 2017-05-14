package decorator

class GreenOlives(val pizza: Pizza) extends PizzaDecorator(pizza) {

  val desc = "-Green Olives-"
  val price = 0.40

  override def getDesc: String = pizza.getDesc + desc

  override def getPrice: Double = pizza.getPrice + price
}

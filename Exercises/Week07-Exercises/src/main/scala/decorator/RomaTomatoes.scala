package decorator

class RomaTomatoes(val pizza: Pizza) extends PizzaDecorator(pizza)  {

  val desc = "-Roma Tomatoes-"
  val price = 0.50

  override def getDesc: String = pizza.getDesc + desc

  override def getPrice: Double = pizza.getPrice + price

}

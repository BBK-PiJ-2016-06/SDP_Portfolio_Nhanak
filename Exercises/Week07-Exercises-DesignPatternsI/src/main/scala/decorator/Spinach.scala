package decorator

class Spinach(val pizza: Pizza) extends PizzaDecorator(pizza)  {

  val desc = "-Spinach-"
  val price = 0.50

  override def getDesc: String = pizza.getDesc + desc

  override def getPrice: Double = pizza.getPrice + price

}

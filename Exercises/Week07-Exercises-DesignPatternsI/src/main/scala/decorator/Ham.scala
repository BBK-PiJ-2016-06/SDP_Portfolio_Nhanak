package decorator

class Ham(val pizza: Pizza) extends PizzaDecorator(pizza)  {

  val desc = "-Ham-"
  val price = 1.50

  override def getDesc: String = pizza.getDesc + desc

  override def getPrice: Double = pizza.getPrice + price

}

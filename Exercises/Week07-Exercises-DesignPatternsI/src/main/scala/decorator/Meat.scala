package decorator

class Meat(val pizza: Pizza) extends PizzaDecorator(pizza) {

  val desc = "-Meat-"
  val price = 1.50

  override def getDesc: String = pizza.getDesc + desc

  override def getPrice: Double = pizza.getPrice + price

}

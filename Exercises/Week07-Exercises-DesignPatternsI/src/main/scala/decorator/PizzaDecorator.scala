package decorator

/**
  * Created by nathanhanak on 2/25/17.
  */
abstract class PizzaDecorator(pizza: Pizza) extends Pizza {

  def getDesc: String = pizza.getDesc

  def getPrice: Double = pizza.getPrice


}

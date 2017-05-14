package factory

/**
  * Created by nathanhanak on 2/21/17.
  */
class ConcreteProduct(var name: String, var price: Double) extends Product {

  override def setName(name: String): Unit = this.name = name

  override def memberDiscountPrice: Double = price * .75
}
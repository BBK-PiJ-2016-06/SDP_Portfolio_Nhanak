package factory

/**
  * Created by nathanhanak on 2/21/17.
  */
class Creator {

  def getInstance(prodName: String) : Product = prodName match {
    case "phone" => new ConcreteProductPhone("phone", 179.99, "Nokia")
    case "Halo" => new ConcreteProductGame("Game: Halo", 59.99, "Xbox")
    case _ => new ConcreteProduct(prodName, 20.00)
  }

}

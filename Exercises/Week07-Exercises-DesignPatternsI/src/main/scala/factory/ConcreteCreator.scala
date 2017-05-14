package factory

/**
  * Created by nathanhanak on 2/21/17.
  */
class ConcreteCreator extends Creator {

  override def getInstance(prodName:String) : ConcreteProduct = prodName match {
    case "Smartphone" => new ConcreteProductPhone("Iphone", 479.99, "Apple")
    case "PS4 Game" => new ConcreteProductGame("Game: GTA V", 59.99, "PS4")
  }

}

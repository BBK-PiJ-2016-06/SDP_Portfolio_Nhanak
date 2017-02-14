package testingExercise

import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter

/**
  * Created by nathanhanak on 2/10/17.
  */
class PizzaSpec extends FunSpec with BeforeAndAfter {

  var pizza: Pizza = _

  before {
    pizza = new Pizza
  }

  describe("A Pizza") {

    it("should start with no toppings") {
      assert(pizza.getToppings.size == 0)
    }

    it("should allow addition of toppings") {
      pizza.addTopping(Topping("Pepperoni"))
      pizza.addTopping(Topping("Green Pepper"))
      assert(pizza.getToppings.size == 2)
    }

    ignore("should allow removal of toppings") (pending)
  }



}
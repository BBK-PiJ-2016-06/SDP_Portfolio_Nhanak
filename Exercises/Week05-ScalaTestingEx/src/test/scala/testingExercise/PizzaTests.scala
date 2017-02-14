package testingExercise

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

/**
  * Created by nathanhanak on 2/10/17.
  */
class PizzaTests extends FunSuite with BeforeAndAfter {

  var pizza: Pizza = _

  before {
    pizza = new Pizza
  }

  test("new pizza has zero toppings") {
    assert(pizza.getToppings.size == 0)
  }

  test("adding one topping") {
    pizza.addTopping(Topping("green olives"))
    assert(pizza.getToppings.size === 1)
  }

  // mark that you want a test here in the future
  test ("test pizza pricing") (pending)

  ignore("new pizza has zero toppings (version 2)") {
    // intentional error here; size should be 0
    assert(pizza.getToppings.size === 1)
  }

  ignore ("new pizza has zero toppings (version 3)") {
    // `expectResult` is now `assertResult`
    // expectResult(1) {
    assertResult(1) {
      pizza.getToppings.size
    }
  }

  test ("catching an exception") {
    val thrown = intercept[Exception] {
      pizza.boom
    }
    assert(thrown.getMessage === "Boom!")
  }

  test("new pizza has zero toppings", DatabaseTest) {
    //assert(pizza.getToppings.size === 1)
    assertResult(0) {
      pizza.getToppings.size
    }
  }

}

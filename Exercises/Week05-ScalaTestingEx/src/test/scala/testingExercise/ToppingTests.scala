package testingExercise

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

/**
  * Created by nathanhanak on 2/10/17.
  */
class ToppingTests extends FunSuite with BeforeAndAfter {

  var pizza : Pizza = _

  before {
    pizza = new Pizza
  }

  // add tests here ...
  test("test topping quantity") {
      for (i <- 1 to 5) { pizza.addTopping(Topping("Extra cheese") ) }
    assert(pizza.getToppings.size == 5)
  }


}
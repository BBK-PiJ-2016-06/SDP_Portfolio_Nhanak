package testingExercise

import org.scalatest.FunSpec
import org.scalatest.GivenWhenThen

/**
  * Created by nathanhanak on 2/10/17.
  */
class PizzaSpec104 extends FunSpec with GivenWhenThen {

    var pizza: Pizza = _
    var tester: Int = 2

    describe("A Pizza") {

      it ("should allow the addition of toppings") {
        Given("a new pizza")
        pizza = new Pizza

        When("a topping is added")
        pizza.addTopping(Topping("green olives"))

        Then("the topping count should be incremented")
        assert(pizza.getToppings.size == 1)

        And("the topping should be what was added")
        val t = pizza.getToppings(0)
        assert(t === new Topping("green olives"))
      }

      /*When running in SBT
       * type: test-only -- -n DatabaseTest   // to run JUST this test
       * type: test-only -- -l DatabaseTest  // to exclude but run all others
       * Don't type anything special but "test" in SBT and this will be automatically included
       */
      it("Should start with no toppings", DatabaseTest) {
        Given("a new pizza")
        pizza = new Pizza
        Then("the topping count should be zero")
        assert(pizza.getToppings.size == 0)
      }

      it("Should allow removal of toppings") {
        Given("a new pizza with one topping")
        pizza = new Pizza
        pizza.addTopping(Topping("green olives"))

        When("the topping is removed")
        pizza.removeTopping(Topping("green olives"))

        Then("the topping count should be zero")
        assert(pizza.getToppings.size == 0)

      }
    }



}


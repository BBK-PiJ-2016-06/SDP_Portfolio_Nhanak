package factory

import org.scalatest.FunSpec
import org.scalatest.GivenWhenThen

/**
  * Created by nathanhanak on 2/22/17.
  */
class FactoryTests extends FunSpec with GivenWhenThen {

  val regCreator : Creator = new Creator
  val cCreator : ConcreteCreator = new ConcreteCreator

  describe("A Creator") {

    it("Should create products when calling getInstance(String)") {
      Given("A Creator")

      When("calling getInstance('phone')")
      val myObject = regCreator.getInstance("phone")

      Then("it should create an object that is a product, ConcreteProduct, and ConcreteProductPhone")
      assert(myObject.isInstanceOf[Product])
      assert(myObject.isInstanceOf[ConcreteProduct])
      assert(myObject.isInstanceOf[ConcreteProductPhone])

    }
  }

  describe("A ConcreteCreator") {

    it("Should create products when calling getInstance(String)") {
      Given("A ConcreteCreator")

      When("calling getInstance('game')")
      val myObject = cCreator.getInstance("PS4 Game")

      Then("it should create an object that is a Product, ConcreteProduct, and ConcreteProductGame")
      assert(myObject.isInstanceOf[Product])
      assert(myObject.isInstanceOf[ConcreteProduct])
      assert(myObject.isInstanceOf[ConcreteProductGame])

    }
  }
}

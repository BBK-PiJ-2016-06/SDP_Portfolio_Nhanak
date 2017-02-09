package question2

import org.scalatest.FunSuite

/**
  * Created by nathanhanak on 2/9/17.
  */
class Question2Test extends FunSuite {

  test("Creating Person creates object with First and Last names") {
    val p = new Person("Elizabeth", "III")
    assert(p.firstName == "Elizabeth")
    assert(p.lastName == "III")
  }

  test("Calling companion object person with one string creates new Person object with first and last name") {
    val p = Person("Bernie Sanders")
    assert(p.firstName == "Bernie")
    assert(p.lastName == "Sanders")
  }

  test("Creating PersonAsCase creates object with First and Last names") {
    val p = new PersonAsCase("Noam", "Chomsky")
    assert(p.firstName == "Noam")
    assert(p.lastName == "Chomsky")
  }

  test("Calling companion object person with one string creates new PersonAsCase object with first and last name") {
    val p = PersonAsCase("Albert Einstein")
    assert(p.firstName == "Albert")
    assert(p.lastName == "Einstein")
  }
}

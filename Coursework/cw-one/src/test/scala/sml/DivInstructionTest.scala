package sml

import org.scalatest.FunSpec
import org.scalatest.GivenWhenThen

/**
  * Created by nathanhanak on 2/16/17.
  */
class DivInstructionTest extends FunSpec with GivenWhenThen {

  var divInst: DivInstruction = _
  val m : Machine = new Machine(Labels(), Vector())
  val label = "In1"
  val opCode = "div"
  val resultRegister = 3
  m.regs(4) = 20
  m.regs(5) = 4

  describe("A DivInstruction") {

    it("should print off its label, op instruction, result register, and two operands") {
      Given("A new DivInstruction")
      divInst = new DivInstruction(label, opCode, resultRegister, 6, 2)

      When( "calling toString()")
      assert(divInst.toString().equals(s"$label: $opCode 6 / 2 to $resultRegister" + "\n"))

    }

    it("should store the result of the operation in the given machine") {
      Given("A new DivInstruction")
      divInst = new DivInstruction(label, opCode, resultRegister, 4, 5)

      When("calling execute(Machine), the Machine will store the result in the expected register")
      divInst.execute(m)
      assert(m.regs(resultRegister) == 5)
    }

    it("should create a new instance of a divInstruction object") {
      Given("a DivInstruction object instantiated from its singleton object's apply method")
      val dI : DivInstruction = DivInstruction.apply(label, resultRegister, 4, 5)

      When("calling toString(), it prints as expected.")
      assert(dI.toString().equals(s"$label: $opCode 4 / 5 to $resultRegister" + "\n"))

      Then("calling execute(Machine) from that object will store the result in the machine as expected")
      dI.execute(m)
      assert(m.regs(resultRegister) == 5)
    }

    it("should throw an exception if the result, op1, or op2 are out of the bounds of the machine's regs") {
      Given("an array of DivInstructions with a negative or overly large results, op1 or op2's")
      val divInstArray: Array[DivInstruction] = Array(DivInstruction.apply(label, -3, 4, 5), DivInstruction.apply(label, 33, 4, 5),
        DivInstruction.apply(label, 3, 44, 5), DivInstruction.apply(label, 3, 4, -5), DivInstruction.apply(label, 3, 4, 55) )


      When("calling execute with out of bounds fields, it throws IndexOutOfBoundsExceptions")
      for (i <- divInstArray.indices)
        intercept[IndexOutOfBoundsException] {
          divInstArray(i).execute(m)
        }
    }


  }

}

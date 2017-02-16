package sml

import org.scalatest.FunSpec
import org.scalatest.GivenWhenThen

/**
  * Created by nathanhanak on 2/16/17.
  */
class MulInstructionTest extends FunSpec with GivenWhenThen {

  var mulInst: MulInstruction = _
  val m : Machine = new Machine(Labels(), Vector())
  val label = "In1"
  val opCode = "mul"
  val resultRegister = 3
  m.regs(4) = 10
  m.regs(5) = 4

  describe("A MulInstruction") {

    it("should print off its label, op instruction, result register, and two operands") {
      Given("A new MulInstruction")
      mulInst = new MulInstruction(label, opCode, resultRegister, 6, 2)

      When( "calling toString()")
      assert(mulInst.toString().equals(s"$label: $opCode 6 * 2 to $resultRegister" + "\n"))

    }

    it("should store the result of the operation in the given machine") {
      Given("A new MulInstruction")
      mulInst = new MulInstruction(label, opCode, resultRegister, 4, 5)

      When("calling execute(Machine), the Machine will store the result in the expected register")
      mulInst.execute(m)
      assert(m.regs(resultRegister) == 40)
    }

    it("should create a new instance of a mulInstruction object") {
      Given("a MulInstruction object instantiated from its singleton object's apply method")
      val sI : MulInstruction = MulInstruction.apply(label, resultRegister, 4, 5)

      When("calling toString(), it prints as expected.")
      assert(sI.toString().equals(s"$label: $opCode 4 * 5 to $resultRegister" + "\n"))

      Then("calling execute(Machine) from that object will store the result in the machine as expected")
      sI.execute(m)
      assert(m.regs(resultRegister) == 40)
    }

    it("should throw an exception if the result, op1, or op2 are out of the bounds of the machine's regs") {
      Given("an array of MulInstructions with a negative or overly large results, op1 or op2's")
      val mulInstArray: Array[MulInstruction] = Array(MulInstruction.apply(label, -3, 4, 5), MulInstruction.apply(label, 33, 4, 5),
        MulInstruction.apply(label, 3, 44, 5), MulInstruction.apply(label, 3, 4, -5), MulInstruction.apply(label, 3, 4, 55) )


      When("calling execute with out of bounds fields, it throws IndexOutOfBoundsExceptions")
      for (i <- mulInstArray.indices)
        intercept[IndexOutOfBoundsException] {
          mulInstArray(i).execute(m)
        }
    }


  }

}

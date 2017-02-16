package sml

import org.scalatest.FunSpec
import org.scalatest.GivenWhenThen

/**
  * Created by nathanhanak on 2/16/17.
  */
class SubInstructionTest extends FunSpec with GivenWhenThen {

  var subInst: SubInstruction = _
  val m : Machine = new Machine(Labels(), Vector())
  val label = "In1"
  val opCode = "sub"
  val resultRegister = 3
  m.regs(4) = 10
  m.regs(5) = 4

  describe("A SubInstruction") {

    it("should print off its label, op instruction, result register, and two operands") {
      Given("A new SubInstruction")
      subInst = new SubInstruction(label, opCode, resultRegister, 6, 2)

      When( "calling toString()")
      assert(subInst.toString().equals(s"$label: $opCode 6 - 2 to $resultRegister" + "\n"))

    }

    it("should store the result of the operation in the given machine") {
      Given("A new SubInstruction")
      subInst = new SubInstruction(label, opCode, resultRegister, 4, 5)

      When("calling execute(Machine), the Machine will store the result in the expected register")
        subInst.execute(m)
        assert(m.regs(resultRegister) == 6)
    }

    it("should create a new instance of a subInstruction object") {
      Given("a SubInstruction object instantiated from its singleton object's apply method")
      val sI : SubInstruction = SubInstruction.apply(label, resultRegister, 4, 5)

      When("calling toString(), it prints as expected.")
      assert(sI.toString().equals(s"$label: $opCode 4 - 5 to $resultRegister" + "\n"))

      Then("calling execute(Machine) from that object will store the result in the machine as expected")
        sI.execute(m)
        assert(m.regs(resultRegister) == 6)
    }

    it("should throw an exception if the result, op1, or op2 are out of the bounds of the machine's regs") {
      Given("an array of SubInstructions with a negative or overly large results, op1 or op2's")
      val subInstArray: Array[SubInstruction] = Array(SubInstruction.apply(label, -3, 4, 5), SubInstruction.apply(label, 33, 4, 5),
        SubInstruction.apply(label, 3, 44, 5), SubInstruction.apply(label, 3, 4, -5), SubInstruction.apply(label, 3, 4, 55) )


      When("calling execute with out of bounds fields, it throws IndexOutOfBoundsExceptions")
        for (i <- subInstArray.indices)
        intercept[IndexOutOfBoundsException] {
            subInstArray(i).execute(m)
        }
    }


  }

}

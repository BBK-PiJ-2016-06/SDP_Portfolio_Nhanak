package sml

import org.scalatest.FunSpec
import org.scalatest.GivenWhenThen

/**
  * Created by nathanhanak on 2/16/17.
  */
class OutInstructionTest extends FunSpec with GivenWhenThen {

  var outInst: OutInstruction = _
  val m : Machine = new Machine(Labels(), Vector())
  val label = "In1"
  val opCode = "out"
  val registerToPrint = 3
  m.regs(3) = 10

  describe("An OutInstruction") {

    it("Should print out the contents of its fields") {
      Given("a new OutInstruction")
      outInst = new OutInstruction(label, opCode, 3)

      When("calling toString()")
      assert(outInst.toString().equals(s"$label: $opCode prints register: $registerToPrint" + "\n"))

    }

    it("should throw an exception if the requested register is out bounds of the machine's regs") {
      Given("an array of OutInstructions with a negative or overly large register")
      val OutInstArray: Array[OutInstruction] = Array(OutInstruction(label, -4), OutInstruction(label, 33) )


      When("calling execute with out of bounds fields, it throws IndexOutOfBoundsExceptions")
      for (i <- OutInstArray.indices)
        intercept[IndexOutOfBoundsException] {
          OutInstArray(i).execute(m)
        }
    }
  }
}

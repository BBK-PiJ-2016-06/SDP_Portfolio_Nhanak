package sml

import org.scalatest.{BeforeAndAfter, FunSpec, GivenWhenThen}

/**
  * Created by nathanhanak on 2/17/17.
  */
class BnzInstructionTest extends FunSpec with GivenWhenThen with BeforeAndAfter {

  var bnzInst: BnzInstruction = _
  var labels: Labels = _
  val destinationLabel = "In3"
  val bnzLabel = "In4"
  var insts: Vector[Instruction] = scala.collection.immutable.Vector.empty
  var m : Machine = _
  val checkedRegister = 1


  before {
    labels = Labels()
    labels.add("In1")
    labels.add("In2")
    labels.add(destinationLabel)
    labels.add(bnzLabel)
  }

  describe("A BnzInstruction") {

    it("Should tell a machine to jump and re-execute its instructions from the desired destination label if the checked register !=0") {
      Given("A machine using a BnzInstruction with a SubInstruction, decrementing register 1 by 1 until 0")
      val prog = insts :+ LinInstruction("I1", 1, 3) :+ LinInstruction("I2", 2, 1) :+
        SubInstruction(destinationLabel, 1, 1, 2) :+ BnzInstruction(bnzLabel, 1, destinationLabel)
      val m2 = new Machine(labels, prog)

      When("calling execute")
      m2.execute()
      Then("the expected register should have decremented to 0 upon completion")
      assert(m2.regs(1) == 0)
    }

    it("Should print out its fields") {
      Given("A new BnzInstruction")
      bnzInst = new BnzInstruction(bnzLabel, "bnz", checkedRegister, destinationLabel)

      When("calling toString()")
        assert(bnzInst.toString().equals(s"$bnzLabel: bnz if reg: $checkedRegister != 0 jump to $destinationLabel" + "\n"))
    }

    it("should create a new instance of BnzInstruction") {
      Given("A val created by calling singleton object's apply")
      val instruction = BnzInstruction(bnzLabel, checkedRegister, destinationLabel)

      When("calling toString() it prints as an object of the parent class would")
      assert(instruction.toString().equals(s"$bnzLabel: bnz if reg: $checkedRegister != 0 jump to $destinationLabel" + "\n"))
    }


  }

}

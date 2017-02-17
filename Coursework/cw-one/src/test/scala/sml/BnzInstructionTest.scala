package sml

import org.scalatest.FunSpec
import org.scalatest.GivenWhenThen

/**
  * Created by nathanhanak on 2/17/17.
  */
class BnzInstructionTest extends FunSpec with GivenWhenThen {

  var bnzInst: BnzInstruction = _
  val m : Machine = new Machine(Labels(), Vector())
  val bnzLabel = "In2"
  val checkedRegister = 4
  val destinationLabel = "In1"

  describe("A BnzInstruction") {

    it("Should print out its fields") {
      Given("A new BnzInstruction")
      bnzInst = new BnzInstruction(bnzLabel, "bnz", checkedRegister, destinationLabel)

      When("calling toString()")
        assert(bnzInst.toString().equals(s"$bnzLabel: bnz if reg: $checkedRegister != 0 jump to $destinationLabel" + "\n"))
    }

    it("Should ")
  }

}

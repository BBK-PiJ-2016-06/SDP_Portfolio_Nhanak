package sml

/**
  * Created by nathanhanak on 2/16/17.
  */
class OutInstruction(label: String, op: String, val regToPrint: Int) extends Instruction(label, op) {

  /**
    * fetches the value of the indicated register and prints it to console
    *
    * @param m a Machine with pre-loaded values in its registers
    */
  override def execute(m: Machine): Unit = println(s"${m.regs(regToPrint)} ")

  override def toString(): String = {
    super.toString + " " + s"prints register: $regToPrint" + "\n"
  }

}

object OutInstruction {
  def apply(label: String, register: Int): OutInstruction =
    new OutInstruction(label, "out", register)
}
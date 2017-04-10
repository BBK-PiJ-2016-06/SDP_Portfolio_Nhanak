package sml

case class LinInstruction(label: String, opcode: String, register: Int, value: Int) extends Instruction(label, opcode) {

  /**
    * Loads a value to store in the machine's specified register
    *
    * @param m a Machine with pre-loaded values in its registers
    */
  override def execute(m: Machine): Unit = m.regs(register) = value

  override def toString(): String = {
    super.toString + " register " + register + " value is " + value + "\n"
  }
}

object LinInstruction {
  def apply(label: String, register: Int, value: Int): LinInstruction =
    new LinInstruction(label, "lin", register, value)
}
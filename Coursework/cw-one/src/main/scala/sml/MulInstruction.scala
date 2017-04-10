package sml

/**
  * Created by nathanhanak on 2/16/17.
  */
class MulInstruction(label: String, op: String, val result: Int, val op1: Int, val op2: Int)
  extends Instruction(label, op) {

  /**
    * Fetches values of two registers from machine,
    * multiplies the values and stores result in indicated register.
    *
    * @param m a Machine with pre-loaded values in its registers
    */
  override def execute(m: Machine): Unit = {
    val value1 = m.regs(op1)
    val value2 = m.regs(op2)
    m.regs(result) = value1 * value2
  }

  override def toString(): String = {
    super.toString + " " + op1 + " * " + op2 + " to " + result + "\n"
  }
}

object MulInstruction {

  def apply(label: String, result: Int, op1: Int, op2: Int): MulInstruction =
    new MulInstruction(label, "mul", result, op1, op2)
}
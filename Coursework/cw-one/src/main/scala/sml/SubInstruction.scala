package sml

/**
  * Created by nathanhanak on 2/16/17.
  */
class SubInstruction(label: String, op: String, val result: Int, val op1: Int, val op2: Int)
  extends Instruction(label, op) {

  override def execute(m: Machine) = {
    val value1 = m.regs(op1)
    val value2 = m.regs(op2)
    m.regs(result) = value1 - value2
  }

  override def toString(): String = {
    super.toString() + s" will store result of op1:$op1 - op2:$op2 in result register:$result"
  }

}

object SubInstruction {

  def apply(label: String, result: Int, op1: Int, op2: Int) =
    new SubInstruction(label, "sub", result, op1, op2)
}

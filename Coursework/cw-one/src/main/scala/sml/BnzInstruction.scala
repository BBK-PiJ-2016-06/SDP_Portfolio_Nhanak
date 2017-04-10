package sml

/**
  * Created by nathanhanak on 2/16/17.
  */
class BnzInstruction(label: String, op: String, register: Int, toLabel: String) extends Instruction(label, op) {

  /**
    * searches the machine's label seq to find label containing the desired destination label
    * once found, retrieves the index and resets the machine's pc to match that index causing
    * instructions to repeat from that point.
    *
    * @param m a Machine with pre-loaded values in its registers
    */
  override def execute(m: Machine): Unit = {
    if (m.regs(register) != 0) {
      m.pc = m.labels.labels.indexWhere(p => p.equals(toLabel), 0)
    }
  }

  override def toString(): String =
    super.toString() + s" if reg: $register != 0 jump to $toLabel" + "\n"

}

object BnzInstruction {
  def apply(label: String, register: Int, toLabel: String): BnzInstruction =
    new BnzInstruction(label, "bnz", register, toLabel)
}

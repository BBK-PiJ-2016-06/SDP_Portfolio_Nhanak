package sml

/**
  * Created by nathanhanak on 2/16/17.
  */
class BnzInstruction(label:String, op:String, register:Int, toLabel:String) extends Instruction(label, op) {

  override def execute(m: Machine) = ???


  override def toString(): String =
    super.toString() + s" if reg: $register != 0 jump to $toLabel" + "\n"

}

object BnzInstruction {
  def apply(label:String, register:Int, toLabel:String) = new BnzInstruction(label, "bnz", register, toLabel)
}

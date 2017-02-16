package sml

/**
  * Created by nathanhanak on 2/16/17.
  */
class BnzInstruction(label:String, op:String, register:Int, toLabel:String) extends Instruction(label, op) {

  override def execute(m: Machine) =
    if

  override def toString(): String =
    super.toString() + s"reg: $register"

}

package sml

/**
  * Created by nathanhanak on 2/16/17.
  */
class OutInstruction(label:String, op:String, val regToPrint:Int) extends Instruction(label, op) {

  //fetches the value of the indicated register and prints it to console
  override def execute(m: Machine) = print(m.regs(regToPrint) + " ")

  override def toString(): String = {
    super.toString + " " + s"prints register: $regToPrint" +  "\n"
  }


}

object OutInstruction {
  def apply(label:String, register:Int) =
    new OutInstruction(label, "out", register)
}
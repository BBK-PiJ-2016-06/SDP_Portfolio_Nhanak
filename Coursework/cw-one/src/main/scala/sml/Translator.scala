package sml

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {

  /**
    * translate the small program in the file into labels (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.length > 0) {
        labels.add(fields(0))
        val instFac = new SMLInstructionFactory()
        program = program :+ instFac.makeInstruction(fields)
      }
    }
    new Machine(labels, program)
  }

}

object Translator {
  def apply(file: String): Translator = new Translator(file)
}

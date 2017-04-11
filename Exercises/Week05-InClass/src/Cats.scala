/**
  * Created by nathanhanak on 2/7/17.
  */

// only do objects if there are going to be only one. In this case there could be many Lions, Panthers, etc.
// so use class


sealed trait Feline {
  def dinner: Food
}

final case class Lion() extends Feline {
  def dinner: Food = Antelope
}

final case class Tiger() extends Feline {
  def dinner: Food = TigerFood
}

final case class Panther() extends Feline {
  def dinner : Food = Licorice
}

final case class Cat() extends Feline {
  def dinner : Food = Mice()
}



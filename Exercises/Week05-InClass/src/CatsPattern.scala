

/**
  * Created by nathanhanak on 2/7/17.
  */

sealed trait FelinePattern {
  def dinner: Food =
    this match {
      case Lion() => Antelope
      case Tiger() => TigerFood
      case Panther() => Licorice
      case Cat() => Mice()

    }

}

final case class Lion() extends FelinePattern
final case class Tiger() extends FelinePattern
final case class Panther() extends FelinePattern
final case class Cat() extends FelinePattern

object Dinner {
  def dinner( feline: Feline): Food =
    feline match {
      case Lion() => Antelope
      case Tiger() => TigerFood
      case Panther() => Licorice
      case Cat() => Mice()
    }
}
/**
  * Created by nathanhanak on 2/7/17.
  */
sealed trait TrafficLight2 {

  def next : TrafficLight2 = // like saying  def next(): TrafficLight2 . Or in java public TrafficLight2 next() {...}
    this match {
    case Red => Green
    case Green => Amber
    case Amber => Red // will fail if we don't include it Amber's match, because we define it below
      // case _ => Red --- not good practice when you know all the cases
  }
}

final case object Red extends TrafficLight2
final case object Amber extends TrafficLight2
final case object Green extends TrafficLight2

sealed trait TrafficLight{
  def next: TrafficLight
}

final case object Red extends TrafficLight{
  override def next = Green
}
final case object Amber extends TrafficLight{
  override def next = Red
}
final case object Green extends TrafficLight {
  override def next = Amber
}



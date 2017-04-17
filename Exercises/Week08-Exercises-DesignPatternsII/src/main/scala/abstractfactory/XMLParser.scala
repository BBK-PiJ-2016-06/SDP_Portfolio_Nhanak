package abstractfactory

trait XMLParser {
  def parse : String
}

//NYC Parsers below
case class NYCErrorXMLParser() extends XMLParser {
  override def parse: String = "NYC Error XML Message"
}
case class NYCFeedbackXMLParser() extends XMLParser {
  override def parse: String = "NYC Feedback XML Message"
}
case class NYCResponseXMLParser() extends XMLParser {
  override def parse: String = "NYC Response XML Message"
}
case class NYCOrderXMLParser() extends XMLParser {
  override def parse: String = "NYC Order XML Message"
}
//London Parsers below
case class LondonErrorXMLParser() extends XMLParser {
  override def parse: String = "London Error XML Message"
}
case class LondonFeedbackXMLParser() extends XMLParser {
  override def parse: String = "London Feedback XML Message"
}
case class LondonResponseXMLParser() extends XMLParser {
  override def parse: String = "London Response XML Message"
}
case class LondonOrderXMLParser() extends XMLParser {
  override def parse: String = "London Order XML Message"
}
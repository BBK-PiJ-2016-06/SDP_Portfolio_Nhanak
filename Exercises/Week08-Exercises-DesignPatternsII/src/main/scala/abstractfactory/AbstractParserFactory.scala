package abstractfactory

trait AbstractParserFactory {
  def getParserInstance(parserType: String): XMLParser
}

case class ConcreteNYCParserFactory() extends AbstractParserFactory {
  override def getParserInstance(parserType: String): XMLParser = parserType.toUpperCase match {
    case "NYCORDER" => NYCOrderXMLParser()
    case "NYCERROR" => NYCErrorXMLParser()
    case "NYCFEEDBACK" => NYCFeedbackXMLParser()
    case "NYCRESPONSE" => NYCResponseXMLParser()
  }
}

case class ConcreteLondonParserFactory() extends AbstractParserFactory {
  override def getParserInstance(parserType: String): XMLParser = parserType.toUpperCase match {
    case "LONDONORDER" => LondonOrderXMLParser()
    case "LONDONERROR" => LondonErrorXMLParser()
    case "LONDONFEEDBACK" => LondonFeedbackXMLParser()
    case "LONDONRESPONSE" => LondonResponseXMLParser()
  }
}
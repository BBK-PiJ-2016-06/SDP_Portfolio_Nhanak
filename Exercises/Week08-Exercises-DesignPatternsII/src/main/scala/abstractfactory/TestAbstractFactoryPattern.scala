package abstractfactory

object TestAbstractFactoryPattern {
  def main(args: Array[String]) {
    var parserFactory: AbstractParserFactory = ParserFactoryProducer.getFactory("NYCFactory")
    var parser: XMLParser = parserFactory.getParserInstance("NYCORDER")
    var msg: String = ""
    msg = parser.parse
    println(msg)
    println("************************************")
    parserFactory = ParserFactoryProducer.getFactory("LondonFactory")
    parser = parserFactory.getParserInstance("LondonFEEDBACK")
    msg = parser.parse
    println(msg)
  }
}

/*
ParserFactoryProducer -> takes in string which tells it what type of Factory to produce
  , makes an AbstractParserFactory
    AbstractParserFactory -> makes an XMLParser
        XMLParser -> spits out a String as a message msg
*/
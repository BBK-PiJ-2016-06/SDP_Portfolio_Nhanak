package decoupled

object HelloWorldDecoupled {
  def main(args: Array[String]) {
    lazy val mr: StandardOutMessageRenderer = new StandardOutMessageRenderer(mp)
    lazy val mp: HelloWorldMessageProvider = new HelloWorldMessageProvider
    //mr.setMessageProvider(mp)
    mr.render
  }
}
package decoupled

class StandardOutMessageRenderer(var messageProvider: HelloWorldMessageProvider) {

  //messageProvider: HelloWorldMessageProvider

  def render {
    if (messageProvider == null) {
      throw new RuntimeException("You must set the property messageProvider of class:" + classOf[StandardOutMessageRenderer].getName)
    }
    println(messageProvider.getMessage)
  }

  def getMessageProvider: HelloWorldMessageProvider = {
    return messageProvider
  }

  def setMessageProvider(provider: HelloWorldMessageProvider) {
    messageProvider = provider
  }
}
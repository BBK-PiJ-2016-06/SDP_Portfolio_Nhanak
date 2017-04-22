package chain

case class AudioFileHandler(s: String) extends Handler {

  var handler : Handler = _

  override def setHandler(handler: Handler): Unit = this.handler = handler

  override def process(file: File): Unit = {
    if (!file.fileType.equals("audio")) {
      println(s"$s forwarding request on ${file.fileName} - ${file.fileType} to $getHandlerName")
      handler.process(file)
    } else {
      println(s"$s is saving ${file.fileName} . ${file.fileName} ")
    }
  }

  override def getHandlerName(): String = s

}

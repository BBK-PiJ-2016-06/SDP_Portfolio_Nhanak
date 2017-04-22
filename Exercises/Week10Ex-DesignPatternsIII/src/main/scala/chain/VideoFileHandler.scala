package chain

case class VideoFileHandler(s: String) extends Handler {

  var handler : Handler = _

  override def setHandler(handler: Handler): Unit = this.handler = handler

  override def process(file: File): Unit = {
    if (!file.fileType.equals("video")) {
      println(s"$s forwarding request on ${file.fileName} - ${file.fileType} to ${handler.getHandlerName}")
      handler.process(file)
    } else {
      println(s"$s is saving ${file.fileName} . ${file.fileName} ")
    }
  }

  override def getHandlerName(): String = s
}

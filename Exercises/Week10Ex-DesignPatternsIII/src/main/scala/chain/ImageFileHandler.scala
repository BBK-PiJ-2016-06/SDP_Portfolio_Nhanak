package chain

case class ImageFileHandler(s: String) extends Handler {

  var handler : Handler = _

  override def setHandler(handler: Handler): Unit = this. handler = handler

  override def process(file: File): Unit = {
    if (!file.fileType.equals("image")) {
      println("Not a file type this application can handle")
    } else {
      println(s"$s is saving ${file.fileName} . ${file.fileName} ")
    }
  }

  override def getHandlerName(): String = s
}

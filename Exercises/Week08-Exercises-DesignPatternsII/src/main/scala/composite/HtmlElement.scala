package composite

import java.util

case class HtmlElement(s: String) extends HtmlTag(s) {

  var startTag : String = new String()
  var endTag : String = new String()
  var htmlBody : String = new String()
  val htmlChildren : util.List[HtmlTag] = new util.ArrayList()


  override def setStartTag(tag: String): Unit = startTag = tag

  override def setEndTag(tag: String): Unit = endTag = tag

  override def generateHtml: Unit = println(s"  $startTag$htmlBody$endTag")
}

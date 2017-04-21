package composite

import java.util.List

abstract class HtmlTag(tagName: String) {

  var htmlBody : String
  val htmlChildren : List[HtmlTag]

  def getTagName: String = tagName

  def setStartTag(tag: String)

  def setEndTag(tag: String)

  def setTagBody(tagBody: String) = htmlBody = tagBody

  def addChildTag(htmlTag: HtmlTag) = htmlChildren.add(htmlTag)

  def removeChildTag(htmlTag: HtmlTag) = htmlChildren.remove(htmlTag)

  def getChildren: List[HtmlTag] = htmlChildren

  def generateHtml
}
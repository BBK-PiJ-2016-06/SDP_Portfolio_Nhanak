package observer

import scala.collection.mutable.ListBuffer

class CommentaryObject(var subscribers: ListBuffer[Observer], val title: String) extends Subject with Commentary {

  var latestUpdate = ""

  override def subscribeObserver(observer: Observer): Unit = {
    println(s"Subscribing new Observer: ${observer.hashCode()}")
    subscribers += observer
  }

  override def unSubscribeObserver(observer: Observer): Unit = {
    println(s"Unsubscribing Observer: ${observer.hashCode()}")
    subscribers -= observer
  }

  override def notifyObservers(): Unit = {
    for ( observer <- subscribers) {
      observer.update(subjectDetails)
    }
  }

  override def subjectDetails: String = title + "\n" + latestUpdate

  override def setDesc(update: String): Unit = {
    latestUpdate = update
    notifyObservers()
  }
}

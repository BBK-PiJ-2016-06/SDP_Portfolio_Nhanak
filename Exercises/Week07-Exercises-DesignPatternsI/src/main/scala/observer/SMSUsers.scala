package observer

case class SMSUsers(s: Subject, msg: String) extends Observer {

  var latestUpdate = "Welcome to Sports Lobby Live Update"

  def update(desc: String):Unit = {
    latestUpdate = desc
    println(s"User ${this.hashCode()} received update: $desc")
  }


  def subscribe() = s.subscribeObserver(this)

  def unSubscribe() = s.unSubscribeObserver(this)


}

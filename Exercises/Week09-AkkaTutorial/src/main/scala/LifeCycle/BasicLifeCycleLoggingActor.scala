package LifeCycle


import akka.actor.{ActorLogging, Actor}
import akka.event.LoggingReceive

class BasicLifecycleLoggingActor extends Actor with ActorLogging{

  var counter = 0;

  log.info ("Inside BasicLifecycleLoggingActor Constructor")
  log.info (context.self.toString())
  override def preStart() ={
    counter+= 1
    log.info(s"Inside the preStart method of BasicLifecycleLoggingActor $counter times")
  }

  def receive = LoggingReceive{
      case "hello" => log.info ("hello")
      case "Stop" => log.info("Stopping via message"); context.stop(self)
  }

  override def postStop()={
    log.info ("Inside postStop method of BasicLifecycleLoggingActor")
  }

}
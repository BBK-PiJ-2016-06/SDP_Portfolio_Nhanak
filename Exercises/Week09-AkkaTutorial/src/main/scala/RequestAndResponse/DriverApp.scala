package RequestAndResponse

import RequestAndResponse.StudentProtocol.InitSignal
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef

object DriverApp extends App {

  //Initialize the ActorSystem
  val system = ActorSystem("UniversityMessageSystem")

  //construct the teacher actor
  val teacherRef = system.actorOf(Props[TeacherActor], "teacherActor")

  //construct the Student Actor - pass the teacher actorref as a constructor parameter to StudentActor
  val studentRef = system.actorOf(Props(new StudentActor(teacherRef)), "studentActor")

  //send a message to the Student Actor
  studentRef ! InitSignal

  //Let's wait for a couple of seconds before we shut down the system
  Thread.sleep(2000)

  //Shut down the ActorSystem.
  system.terminate()

}
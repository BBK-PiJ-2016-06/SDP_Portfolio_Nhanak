package LifeCycle

import akka.actor.{ActorSystem, Props}

object LifecycleApp extends App{

  val actorSystem=ActorSystem("LifecycleActorSystem")
  val lifecycleActor=actorSystem.actorOf(Props[BasicLifecycleLoggingActor],"lifecycleActor")


  lifecycleActor!"hello"
  //actorSystem.stop(lifecycleActor);
  lifecycleActor!"Stop"

  //wait for a couple of seconds before shutdown
  Thread.sleep(2000)
  actorSystem.terminate()

}
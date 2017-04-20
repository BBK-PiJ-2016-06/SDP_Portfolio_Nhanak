package facadepattern


case class ScheduleServerImpl() extends ScheduleServer {

  override def startBooting: Unit = print("Starting system from scratch \n")

  override def readSystemConfigFile: Unit = print("Reading that SysConfigFile \n")

  override def init: Unit = print("Now initializing \n")

  override def initializeContext: Unit = print("Starting context \n")

  override def initializeListeners: Unit = print("Gather round now listeners \n")

  override def createSystemObjects: Unit = print("Make all the objects minions \n")

  override def releaseProcesses: Unit = print("Time for processes to go home \n")

  override def destory: Unit = print("KILL SMASH DIE \n")

  override def destroySystemObjects: Unit = print("Kill your darlings, your system object darlings \n")

  override def destoryListeners: Unit = print("Engage in secrecy coverup, kill listeners \n")

  override def destoryContext: Unit = print("Confuse them all, eliminate context \n")

  override def shutdown: Unit = print("Goodbye Dave \n")
}

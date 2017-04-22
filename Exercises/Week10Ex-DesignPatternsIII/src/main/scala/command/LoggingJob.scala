package command

class LoggingJob extends Job {

  private var logger : Logging = _

  def setLogging(logging: Logging): Unit = logger = logging

  override def run(): Unit = logger.log
}
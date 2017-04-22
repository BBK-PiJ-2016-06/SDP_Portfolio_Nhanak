package command

class SmsJob extends Job {

  var sms : Sms = _

  def setSms(sms: Sms): Unit = this.sms = sms

  override def run(): Unit = sms.sendSms
}
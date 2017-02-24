package xpay

/**
  * Created by nathanhanak on 2/24/17.
  */
class XpayToPayDAdapter(var payD: PayD) extends Xpay {

  override def getCreditCardNo: String = {
    payD.getCustCardNo
  }

  override def setCreditCardNo(creditCardNo: String): Unit = {
    payD.setCustCardNo(creditCardNo)
  }

  override def getCustomerName: String = {
    payD.getCardOwnerName
  }

  override def setCustomerName(customerName: String): Unit = {
    payD.setCardOwnerName(customerName)
  }

  //assumes PayD ExpMonthDate format is XX/XXXX
  override def getCardExpMonth: String = payD.getCardExpMonthDate.substring(0,2)

  //assumes PayD ExpMonthDate format is XX/XXXX
  override def setCardExpMonth(cardExpMonth: String): Unit = {
    val cardCurrentYear = payD.getCardExpMonthDate.substring(2) // gets '/XXXX' of previous ExpMonthDate
    payD.setCardExpMonthDate(cardExpMonth + cardCurrentYear)
  }

  //assumes PayD ExpMonthDate format is XX/XXXX
  override def getCardExpYear: String = {
    payD.getCardExpMonthDate.substring(3)
  }

  //assumes PayD ExpMonthDate format is XX/XXXX
  override def setCardExpYear(cardExpYear: String): Unit = {
    val cardCurrentMonth = payD.getCardExpMonthDate.substring(0,3) // returns 'XX/' of previous ExpMonthDate
    payD.setCardExpMonthDate(cardCurrentMonth + cardExpYear)
  }

  override def getCardCVVNo: Short = payD.getCVVNo.toShort

  override def setCardCVVNo(cardCVVNo: Short): Unit = {
    payD.setCVVNo(cardCVVNo.toInt)
  }

  override def getAmount: Double = payD.getTotalAmount

  override def setAmount(amount: Double): Unit = {
    payD.setTotalAmount(amount)
  }

}

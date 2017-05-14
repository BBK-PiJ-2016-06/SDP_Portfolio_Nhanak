package xpay

/**
  * Created by nathanhanak on 2/24/17.
  */
class PayDImpl extends PayD {

    private var custCardNo: String = null
    private var cardOwnerName:String = null
    private var cardExpMonthDate: String = "XX/XXXX"
    private var cVVNo: Integer = 0
    private var totalAmount: Double = .0


    override def getCustCardNo: String = custCardNo

    override def setCustCardNo(custCardNo: String):Unit = {
      this.custCardNo = custCardNo
    }

    override def getCardOwnerName: String = cardOwnerName

    override def setCardOwnerName(cardOwnerName: String): Unit = {
      this.cardOwnerName = cardOwnerName
    }

    override def getCardExpMonthDate: String = cardExpMonthDate

    override def setCardExpMonthDate(cardExpMonthDate: String): Unit = {
      this.cardExpMonthDate = cardExpMonthDate
    }

    override def getCVVNo: Integer = cVVNo

    override def setCVVNo(cVVNo: Integer): Unit = {
      this.cVVNo = cVVNo
    }

    override def getTotalAmount: Double = totalAmount

    override def setTotalAmount(totalAmount: Double): Unit = {
      this.totalAmount = totalAmount
    }


}

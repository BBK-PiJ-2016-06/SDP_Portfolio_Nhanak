package xpay

/**
  * Created by nathanhanak on 2/24/17.
  */
object PaymentSystemsTest extends App {

  val xPay : Xpay = new XpayImpl
  val payDExt : PayD = new PayDImpl
  val payDForRef: PayD = new PayDImpl
  val adaptedPay : XpayToPayDAdapter = new XpayToPayDAdapter(payDForRef)

  xPay.setCardCVVNo(2573)
  xPay.setCustomerName("Joe Schmoe")
  xPay.setAmount(22.55)
  println(s"xPay's CVV No:  ${xPay.getCardCVVNo}")
  println(s"XPay's cust name: ${xPay.getCustomerName}")
  println(s"XPay's amount: ${xPay.getAmount}" + "\n")

  adaptedPay.setCardExpMonth("06")
  println(s"Adaptor's expiration month should be 06: ${adaptedPay.getCardExpMonth}")
  println(s"Adaptor's expiration year should be XXXX: ${adaptedPay.getCardExpYear}")
  adaptedPay.setCardExpYear("2018")
  println(s"Now Adaptor's expiration year should be 2018: ${adaptedPay.getCardExpYear}")
  adaptedPay.setCardCVVNo(586)
  println(s"Adaptor's CVVNo is converting between short and Integer and should be 586 ${adaptedPay.getCardCVVNo}")
  payDForRef.setCustCardNo("2838999")
  println(s"Adaptor and the payDforRef should return the same cardNo ref: ${adaptedPay.getCreditCardNo} = " +
    s" ${payDForRef.getCustCardNo}")

}

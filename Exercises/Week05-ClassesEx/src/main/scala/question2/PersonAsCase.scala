package question2

/**
  * Created by nathanhanak on 2/9/17.
  */
case class PersonAsCase(firstName:String, lastName:String) {

}

object PersonAsCase {

  def apply(fullname: String): PersonAsCase = {
    val nameArray = fullname.split(" ")
    new PersonAsCase(nameArray(0), nameArray(1))
  }

}
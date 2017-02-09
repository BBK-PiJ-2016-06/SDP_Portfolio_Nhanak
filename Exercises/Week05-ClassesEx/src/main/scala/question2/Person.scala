package question2

/**
  * Created by nathanhanak on 2/9/17.
  */
class Person(val firstName:String, val lastName:String) {

}

object Person {

  def apply(fullname: String): Person = {
    val nameArray = fullname.split(" ")
    new Person(nameArray(0), nameArray(1))
  }

}



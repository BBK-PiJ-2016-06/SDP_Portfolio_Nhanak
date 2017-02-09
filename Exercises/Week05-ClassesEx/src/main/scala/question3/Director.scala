package question3

/**
  * Created by nathanhanak on 2/9/17.
  */
class Director(val firstName:String, val surName:String, val yob:Int) {

  def name():String = firstName + " " + surName
}

object Director {

  def apply(fName:String, lName:String, yearBorn:Int): Director = {
    new Director(fName, lName, yearBorn)
  }

  def older( d1: Director, d2: Director): Director = if (d1.yob < d2.yob) d1 else d2

}

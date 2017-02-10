package question3

/**
  * Created by nathanhanak on 2/10/17.
  */
case class DirectorAsCase( firstName:String,  surName:String,  yob:Int) {

  def name():String = firstName + " " + surName

  def older( d1: Director, d2: Director): Director = if (d1.yob < d2.yob) d1 else d2

}

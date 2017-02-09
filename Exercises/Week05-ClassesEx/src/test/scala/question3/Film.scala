package question3

/**
  * Created by nathanhanak on 2/9/17.
  */
class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {

  def directorsAge(): Int = yearOfRelease - director.yob

  def isDirectedBy(d: Director): Boolean = if (director.equals(d)) true else false

}

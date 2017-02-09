package question3

/**
  * Created by nathanhanak on 2/9/17.
  */
class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {

  def directorsAge(): Int = yearOfRelease - director.yob

  def isDirectedBy(d: Director): Boolean = if (director.equals(d)) true else false

  def copy(newName: String = this.name, newYear: Int = this.yearOfRelease, newRating: Double = this.imdbRating, newDirec : Director = this.director): Film = {
    new Film(newName, newYear, newRating, newDirec)
  }
}

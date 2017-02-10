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

object Film {

  def apply(name: String, yearOfRelease: Int, imdbRating: Double, director: Director ): Film = {
      new Film(name, yearOfRelease, imdbRating, director)
  }

  def highestRating(f1:Film, f2:Film): Film = {
    if (f1.imdbRating > f2.imdbRating) f1 else f2
  }

  def oldestDirectorAtTheTime(f1: Film, f2:Film): Director = {
    if (f1.directorsAge() > f2.directorsAge() ) f1.director else f2.director
  }

}
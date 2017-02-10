package question3

/**
  * Created by nathanhanak on 2/10/17.
  */
case class FilmAsCase(name: String,  yearOfRelease: Int, imdbRating: Double, director: Director) {

  def directorsAge(): Int = yearOfRelease - director.yob

  def isDirectedBy(d: Director): Boolean = if (director.equals(d)) true else false

  def highestRating(f1:Film, f2:Film): Film = {
    if (f1.imdbRating > f2.imdbRating) f1 else f2
  }

  def oldestDirectorAtTheTime(f1: Film, f2:Film): Director = {
    if (f1.directorsAge() > f2.directorsAge() ) f1.director else f2.director
  }
}

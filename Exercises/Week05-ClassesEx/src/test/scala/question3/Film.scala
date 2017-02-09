package question3

/**
  * Created by nathanhanak on 2/9/17.
  * • Film should contain:
– a field name of type String
– a field yearOfRelease of type Int
– a field imdbRating of type Double
– a field director of type Director
– a method directorsAge that returns the age of the director at the time
of release
– a method isDirectedBy that accepts a Director as a parameter and
returns a Boolean
  */
class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {

  def directorsAge(): Int = yearOfRelease - director.yob

}

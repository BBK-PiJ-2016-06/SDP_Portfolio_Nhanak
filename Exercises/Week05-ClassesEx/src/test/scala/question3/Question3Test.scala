package question3

import org.scalatest.FunSuite

/**
  * Created by nathanhanak on 2/9/17.
  */
class Question3Test extends FunSuite {

  test("Calling name on a director returns one string containing its two 'name' fields concatenated") {
    val d = new Director("Steven", "Spielberg", 1946)
    assert(d.name == "Steven Spielberg")
  }

  test("Calling directorsAge returns age of Director of film when film was made") {
    val d = new Director("Ridley", "Scott", 1937)
    val f = new Film("Alien", 1979, 8.5, d)
    assert(f.directorsAge() == 42)
  }

  test("Calling isDirectedBy takes a director for a parameter and returns true or false, accordingly") {
    val qt = new Director("Quentin", "Tarantino", 1963)
    val kb = new Film("Kill Bill: Part I", 2003, 8.1, qt)
    val ss = new Director("Steven", "Soderbergh", 1963)
    val oo = new Film("Ocean's Eleven", 2001, 7.8, ss)
    assert(kb.isDirectedBy(qt))
    assert(!oo.isDirectedBy(qt))
  }

  test("Calling copy with changes in the parameter returns movie with only that field altered"){
    val tg = new Film("True Grit", 2010, 7.7, new Director("Ethan and Joel", "Coen", 1957))
    val what = tg.copy()
    val tgOrig = tg.copy(newYear = 1969, newDirec = new Director("Henry", "Hathaway", 1898))
    //needed to specify names of params because calling out of order from copy()'s original signature
    assert(tgOrig.yearOfRelease == 1969)
    assert(tgOrig.imdbRating == 7.7)
    assert(tgOrig.directorsAge == 71)
  }

  test("Calling apply of a companion object of director returns a director with expected fields") {
    val d = Director.apply("Hayao", "Miyazaki", 1941)
    assert(d.firstName.equals("Hayao"))
    assert(d.surName.equals("Miyazaki"))
    assert(d.yob == 1941)
  }

  test("Calling older of Director companion object returns the older of the two directors") {
    val young = Director.apply("George", "Lucas", 1944)
    val old = Director.apply("Martin", "Scorcese", 1942)
    val result = Director.older(young, old)
    assert(result.firstName.equals("Martin"), s"Martin is older, you returned ${result.firstName}")
    val result2 = Director.older(old, young)
    assert(result2.firstName.equals("Martin"), s"Martin is older, you returned ${result2.firstName}")
  }

  test("Calling highest rating returns the higher rated of the two films") {
    val sa = new Film("Spirited Away", 2001, 8.6, new Director("Hayao", "Miyazaki", 1941))
    val i = new Film("Inception", 2010, 8.8, new Director("Christopher", "Nolan", 1970))
    assert(Film.highestRating(sa, i).equals(i))
  }

  test("Calling oldestDirectorAtTheTime returns the director who was oldest at the time of making the film") {
    val sa = new Film("Spirited Away", 2001, 8.6, new Director("Hayao", "Miyazaki", 1941))
    val i = new Film("Inception", 2010, 8.8, new Director("Christopher", "Nolan", 1970))
    assert(Film.oldestDirectorAtTheTime(sa, i).firstName.equals("Hayao"))
  }

  test("Calling copy on FilmAsCase allows for same usage as copy method for non-case class") {
    val sa = FilmAsCase("Spirited Away", 2001, 8.6, new Director("Hayao", "Miyazaki", 1941))
    val saAlt = sa.copy("Different Movie", imdbRating = 9.5)
    assert(saAlt.name.equals("Different Movie"))
    assert(saAlt.imdbRating.equals(9.5))
    assert(saAlt.director.firstName.equals("Hayao"))
  }

  test("Calling copy on DirectorAsCase allows for same usage as copy method for non-case class") {
    val d1 = DirectorAsCase("George", "Lucas", 1944)
    val d2 = d1.copy("Martin", "Scorcese", 1942)
    assert(d2.firstName.equals("Martin"))
  }



}

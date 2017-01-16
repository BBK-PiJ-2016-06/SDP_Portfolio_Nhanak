import scala.io.StdIn.{readLine, readInt}
import scala.util.Random

object Hammurabi {

  def hammurabi(): Unit = {
    var starved = 0 // how many people starved
    var immigrants = 5 // how many people came to the city
    var population = 100
    var harvest = 3000 // total bushels harvested
    var bushelsPerAcre = 3 // amount harvested for each acre planted
    var rats_ate = 200 // bushels destroyed by rats
    var bushelsInStorage = 2800
    var acresOwned = 1000
    var pricePerAcre = 19 // each acre costs this many bushels
    var plagueDeaths = 0

    printIntroductoryMessage()

    for (i <- 1 to 3) {
      println(s"""O great Hammurabi!
        You are in year   ${i}   of your ten year rule.
        In the previous year   $starved  people starved to death.
        In the previous year   $immigrants   people entered the kingdom.
        The population is now   $population  .
        We harvested   $harvest   bushels at   $bushelsPerAcre   bushels per acre.
        Rats destroyed   $rats_ate   bushels, leaving   $bushelsInStorage   bushels in storage.
        The city owns   $acresOwned   acres of land.
        Land is currently worth   $pricePerAcre   bushels per acre.
        There were   $plagueDeaths   deaths from the plague.""")

      var acresToBuy = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
      acresOwned = acresOwned + acresToBuy

      if (acresToBuy < 1 ) {
        var acresToSell = askHowMuchLandToSell(acresOwned)
        acresOwned -= acresToSell
        bushelsInStorage += acresToSell * pricePerAcre
      }

      var bushelsForFeeding = askHowMuchGrainToDoleOut(bushelsInStorage)
      bushelsInStorage -= bushelsForFeeding

      var acresToPlant = askHowManyAcresToPlant(bushelsInStorage, acresOwned, population)
      bushelsInStorage -= (acresToPlant * 2)

      plagueDeaths = howManyPeopleDiedOfPlague(population)
      population -= plagueDeaths

      starved = howManyPeopleStarved(bushelsForFeeding, population)
      if (starved >= (population*(45/100)) ) {
        println(
          s"""Your poor decisions have caused $starved to starve. Those remaining have revolted
             |and you have been beheaded.
           """.stripMargin)
        return
      }
      population -= starved

    }

  }

  def howManyPeopleStarved(bushelsAllocated:Int, population:Int): Int = {
    val bushelsNeeded = population * 20
    var starvationDeaths = 0
    if (bushelsAllocated < bushelsNeeded) {
      starvationDeaths = (bushelsNeeded - bushelsAllocated)/20
    }
    starvationDeaths
  }

  def howManyPeopleDiedOfPlague(population:Int): Int = {
    var numberOfDeaths = 0
    if (Random.nextInt(100) < 15) {
      numberOfDeaths = population / 2
    }
    numberOfDeaths
  }

  def askHowManyAcresToPlant(bushelsAvailable:Int, acresOwned:Int, population:Int): Int = {
    var acresToPlant = readInt(s"We have ${acresOwned} acres available, how many should we plant?")
    while (acresToPlant > acresOwned) {
      println(s"Oh Great H man, we own but $acresOwned, please choose less.")
      acresToPlant = readInt("So how many acres should we plant?")
    }
    while (bushelsAvailable < acresToPlant * 2) {
      println(s"Oh Great H man, we only have $bushelsAvailable, we need to plant less")
      acresToPlant = readInt("So how many acres should we plant?")
    }
    while (population * 10 < acresToPlant) {
      println(s"Oh great H man, our people cannot farm $acresToPlant, we need to plant less")
      acresToPlant = readInt("So how many acres should we plant?")
    }
    acresToPlant
  }

  def askHowMuchGrainToDoleOut(bushelsAvailable:Int) = {
    var bushelsToGiveOut = readInt("How many bushels will you use to feed the people?")
    while(bushelsToGiveOut > bushelsAvailable) {
      println(s"O Great Hammurabi, we have but $bushelsAvailable on hand to feed the people. Please choose less")
      bushelsToGiveOut = readInt("How many bushels will you use to feed the people?")
    }
    bushelsToGiveOut
  }

  def askHowMuchLandToSell(totalAcres: Int) = {
    var acresToSell = readInt("How many acres will you sell? ")
    while(acresToSell > totalAcres) {
      println(s"O Great Hammurabi, we have but $totalAcres to sell. Please choose less")
      acresToSell = readInt("How many acres will you sell?")
    }
    acresToSell
  }

  def askHowMuchLandToBuy(bushels: Int, price: Int) = { // bushels = current balance
    var acresToBuy = readInt("How many acres will you buy? ")
    while (acresToBuy < 0 || acresToBuy * price > bushels) {
      println("O Great Hammurabi, we have but " + bushels + " bushels of grain!")
      acresToBuy = readInt("How many acres will you buy? ")
    }
    acresToBuy
  }


  def readInt(message:String): Int = {
    try {
      readLine(message).toInt
    } catch {
      case _: Throwable =>
        println("That's not an integer. Please enter an integer.")
        readInt(message)
    }
  }

  def printIntroductoryMessage(): Unit = {

    println(
      """Congratulations, you are the newest ruler of ancient Samaria, elected
          |for a ten year term of office. Your duties are to dispense food, direct
          |farming, and buy and sell land as needed to support your people. Watch
          |out for rat infestations and the plague! Grain is the general currency,
          |measured in bushels. The following will help you in your decisions:
          |* Each person needs at least 20 bushels of grain per year to survive.
          |* Each person can farm at most 10 acres of land.
          |* It takes 2 bushels of grain to farm an acre of land.
          |* The market price for land fluctuates yearly.
          |Rule wisely and you will be showered with appreciation at the end of
          |your term. Rule poorly and you will be kicked out of office!""")
  }
}
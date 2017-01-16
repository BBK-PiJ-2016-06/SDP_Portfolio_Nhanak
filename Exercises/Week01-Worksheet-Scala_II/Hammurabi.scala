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

    var totalStarved = 0
    var totalPopulation = 100


    printIntroductoryMessage()

    for (i <- 1 to 10) {

      totalStarved += starved
      totalPopulation += population

      println(s"""
        O great Hammurabi!
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

      var bushelsForFeeding = askHowMuchGrainToDoleOut(bushelsInStorage, population)
      bushelsInStorage -= bushelsForFeeding

      var acresToPlant = askHowManyAcresToPlant(bushelsInStorage, acresOwned, population)
      bushelsInStorage -= (acresToPlant * 2)

      plagueDeaths = howManyPeopleDiedOfPlague(population)
      population -= plagueDeaths

      starved = howManyPeopleStarved(bushelsForFeeding, population)

      if ( (starved*100)/population >= 45 ) {
        println(
          s"""Your poor decisions have caused $starved to starve. Those remaining have revolted
             |and you have been beheaded.
           """.stripMargin)
        return
      }
      population -= starved

      immigrants = 0
      if (starved == 0) {
        immigrants = howManyNewMigrantsEnteredCity(acresOwned, bushelsInStorage, population)
      }
      population += immigrants

      bushelsPerAcre = Random.nextInt(7)+1
      harvest = acresToPlant * bushelsPerAcre
      bushelsInStorage += harvest

      rats_ate = 0
      if (Random.nextInt(100) < 40) {
        rats_ate = howMuchGrainDidTheRatsEat(bushelsInStorage)
      }
      bushelsInStorage -= rats_ate

      pricePerAcre = 17 + Random.nextInt( (23 - 17) + 1 )

    }

    evaluation(acresOwned, totalStarved, totalPopulation)


  }

  def evaluation(acresOwned:Int, totalStarved:Int, totalPopulation:Int): Unit = {
    var reelect : Boolean = true

    println(s"You let this many people starve: ${totalStarved}")
    println(s"This is how many acres you ended up with ${acresOwned}")
    println(s"This is how many people have ever been in your kingdom: ${totalPopulation}")

    val growthPercentage = ( (acresOwned-1000) * 100) / 1000
    val percentageStarved = (totalStarved * 100) / totalPopulation

    if (percentageStarved > 10) {
      println(s"You let $percentageStarved % of your people starve, you monster")
      reelect = false
    }

    if (growthPercentage < 30 || acresOwned < 1000) {
      println(s"""You started with 1000 acres and ended up with $acresOwned, a $growthPercentage % growth percentage. You suck""")
      reelect = false
    }

    if (reelect) println(s"A land growth of ${growthPercentage} %, not bad \n")

    if (reelect) println("Congrats, you get another term!") else println("You blew it. You were not reelected, and probably executed.")
  }

  def howMuchGrainDidTheRatsEat(bushels:Int): Int = {
    val percentageEaten = 10 + Random.nextInt( (33 - 10) + 1 )
    (bushels * percentageEaten) / 100
  }

  def howManyNewMigrantsEnteredCity(acres:Int, bushels:Int, population:Int): Int = {
    (20 * acres + bushels) / (100 * population) + 1
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
    var acresToPlant = readInt(s"We have ${acresOwned} acres available, how many should we plant? \n")
    while (acresToPlant > acresOwned) {
      println(s"Oh Great H man, we own but $acresOwned, please choose less. \n")
      acresToPlant = readInt("So how many acres should we plant? \n")
    }
    while (bushelsAvailable < acresToPlant * 2) {
      println(s"Oh Great H man, we only have $bushelsAvailable bushels, we need to plant less")
      acresToPlant = readInt("So how many acres should we plant? \n")
    }
    while (population * 10 < acresToPlant) {
      println(s"Oh great H man, our people cannot farm $acresToPlant acres, we need to plant less \n")
      acresToPlant = readInt("So how many acres should we plant? \n")
    }
    acresToPlant
  }

  def askHowMuchGrainToDoleOut(bushelsAvailable:Int, population:Int): Int = {
    var bushelsToGiveOut = readInt(
      s"""How many bushels will you use to feed the people?
        |You need at least ${population * 20} for there to be 0 deaths \n
      """.stripMargin)

    while(bushelsToGiveOut > bushelsAvailable) {
      println(s"O Great Hammurabi, we have but $bushelsAvailable on hand to feed the people. Please choose less")
      bushelsToGiveOut = readInt("How many bushels will you use to feed the people? \n")
    }
    bushelsToGiveOut
  }

  def askHowMuchLandToSell(totalAcres: Int): Int = {
    var acresToSell = readInt("How many acres will you sell? \n")
    while(acresToSell > totalAcres) {
      println(s"O Great Hammurabi, we have but $totalAcres to sell. Please choose less \n")
      acresToSell = readInt("How many acres will you sell? \n")
    }
    acresToSell
  }

  def askHowMuchLandToBuy(bushels: Int, price: Int): Int = { // bushels = current balance
    var acresToBuy = readInt("How many acres will you buy? \n ")
    while (acresToBuy < 0 || acresToBuy * price > bushels) {
      println("O Great Hammurabi, we have but " + bushels + " bushels of grain! \n")
      acresToBuy = readInt("How many acres will you buy? \n ")
    }
    acresToBuy
  }


  def readInt(message:String): Int = {
    try {
      readLine(message).toInt
    } catch {
      case _: Throwable =>
        println("That's not an integer. Please enter an integer. \n")
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
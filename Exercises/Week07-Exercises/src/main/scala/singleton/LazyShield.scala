package singleton

/**
  * Created by nathanhanak on 2/22/17.
  */
class LazyShield private(pg : PowerGenerator) {

  def isProtecting(): Boolean = {
    if (this == null) false else true
  }

}

object LazyShield {

  private var shield : LazyShield = null

  def getInstance(powerGenerator: PowerGenerator): LazyShield = {
    println("loading shield resources")
    Thread.sleep(1000)
    if (shield == null) {
        powerGenerator.usePower(70)
        shield = new LazyShield(powerGenerator)
    }
    shield
  }

  def scan(powerGenerator: PowerGenerator):Unit =
    if (powerGenerator.getPower() > 50) {
      powerGenerator.usePower(50)
      println("all clear")
      powerGenerator.returnPower(50)
    }
    else {
      println("insufficient power")
    }

  //have another method here in the object that does something like sendWarning(Boolean) that uses only a little power
  // then ... try copyting this class in the EagerShield and doing something similar, showing that
  // it can't work because the power is being drained?

}



package singleton

/**
  * Created by nathanhanak on 2/22/17.
  */
class LazyShield private() {

  private var protecting : Boolean = false

  def raiseShield(epg : EagerPowerGenerator) = if (epg.getPower() > 50) protecting = true

  def lowerShield(epg: EagerPowerGenerator): Unit  = {
    protecting = false
    epg.returnPower(50)
  }

}


object LazyShield {

  private var shield : LazyShield = null

  def getInstance(powerGenerator: EagerPowerGenerator): LazyShield = {
    if (shield == null) {
      powerGenerator.usePower(50)
      shield = new LazyShield()
    }
    shield
  }

}



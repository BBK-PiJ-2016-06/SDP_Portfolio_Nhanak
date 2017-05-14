package singleton

/**
  * Created by nathanhanak on 2/23/17.
  */
class EagerShield private() {

  private var protecting : Boolean = false

  def raiseShield(epg : PowerGenerator) = if (epg.getPower() > 50) protecting = true

  def lowerShield(epg : PowerGenerator): Unit  = {
    protecting = false
    epg.returnPower(50)
  }

  def getStatus(): Boolean = protecting

}

object EagerShield {
 
  private val shield : EagerShield = new EagerShield()
  
  def getInstance(pg : PowerGenerator): EagerShield = {
    pg.usePower(70)
    shield
  }

}



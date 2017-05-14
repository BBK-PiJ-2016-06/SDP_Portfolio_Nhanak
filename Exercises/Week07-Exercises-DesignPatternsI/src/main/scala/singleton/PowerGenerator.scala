package singleton

/**
  * Created by nathanhanak on 2/23/17.
  */
class PowerGenerator {

  private var powerAvailable = 100

  def usePower(i : Int):Unit  = {
    if (i > powerAvailable) {
      throw new IllegalArgumentException("Insufficient power")
    } else {
      powerAvailable -= i
    }
  }

  def returnPower(i :Int) = powerAvailable += i

  def getPower(): Int = powerAvailable

}

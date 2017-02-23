package singleton

/**
  * Created by nathanhanak on 2/23/17.
  */
class EagerPowerGenerator {

  private var powerAvailable = 100

  def usePower(i : Int) = powerAvailable -= i

  def returnPower(i :Int) = powerAvailable += i

  def getPower(): Int = powerAvailable

}

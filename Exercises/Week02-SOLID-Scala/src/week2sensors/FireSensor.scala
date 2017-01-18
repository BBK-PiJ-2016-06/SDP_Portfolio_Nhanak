package week2sensors

import scala.util.Random


/**
  * Created by nathanhanak on 1/18/17.
  */
class FireSensor(val location: String) extends Sensors {

  location : String
  var batteryPercentage : Int = 100

  /**
    *  returns true/false for whether the sensor is triggered or not.
    *  has a 5% chance of returning true
    */
  def isTriggered(): Boolean = {
    checkBatteryLife()
    drainBattery(10)
    if (Random.nextInt(100) < 5) true else false
  }

  private[this] def checkBatterylife: Unit = {
    if (batteryPercentage <= 0) {
      throw new IllegalStateException(s"Battery for ${this.getClass.toString} at ${location} is dead")
    }
  }

  private[this] def drainBattery(drainAmount:Int): Unit = {
    batteryPercentage -= drainAmount
  }

  /**
    * returns a description of the location of the sensor such as Lobby
    * 1st floor or In the auditorium.
    * @return
    */
  def getLocation(): String = {
    return location
  }

  /**
    * returns a textual description of the sensor type such as "Fire sensor"
    * or "Smoke sensor".
    * @return
    */
  def getSensortype(): String = {
    return "Fire sensor"
  }

  /**
    * Returns a number between 0-100 where 0 is empty and
    * 100 is fully charged.
    *
    */
  def getBatteryPercentage(): Int = {
    return batteryPercentage
  }

}
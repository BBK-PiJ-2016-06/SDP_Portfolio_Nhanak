package week2sensors

import scala.util.Random


/**
  * Created by nathanhanak on 1/18/17.
  */
class FireSensor(val location: String) extends Sensor {

  private val sensorType: String = "Fire Sensor"
  protected var batteryPercentage : Int = 100

  /**
    *  returns true/false for whether the sensor is triggered or not.
    *  has a 5% chance of returning true
    */
  def isTriggered(): Boolean = {
    checkBatteryLife()
    drainBattery(10)
    if (Random.nextInt(100) < 5) true else false
  }

  protected def checkBatteryLife(): Unit = {
    if (getBatteryPercentage() <= 0) {
      throw new IllegalStateException(s"Battery for ${this.getClass.toString} at ${location} is dead")
    }
  }

  protected def drainBattery(drainAmount:Int): Unit = {
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
    * @return String describing the type of sensor
    */
  def getSensortype(): String = sensorType


  /**
    * Returns a number between 0-100 where 0 is empty and
    * 100 is fully charged.
    *
    */
  def getBatteryPercentage(): Int = {
    return batteryPercentage
  }

}

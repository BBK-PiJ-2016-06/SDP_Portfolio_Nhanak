package week2sensors

/**
  * Created by nathanhanak on 1/18/17.
  */
trait Sensor {

  /**
    *  returns true/false for whether the sensor is triggered or not.
    *  different sensors have different rules applied to them.
    */
  def isTriggered(): Boolean

  /**
    * returns a description of the location of the sensor such as Lobby
    * 1st floor or In the auditorium.
    * @return
    */
   def getLocation(): String

  /**
    * returns a textual description of the sensor type such as "Fire sensor"
    * or "Smoke sensor".
    * @return
    */
  def getSensorType(): String

  /**
    * Returns a number between 0-100 where 0 is empty and
    * 100 is fully charged.
    */
  def getBatteryPercentage(): Int
}

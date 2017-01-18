package week2sensors

import scala.util.Random

/**
  * Created by nathanhanak on 1/18/17.
  */
class SmokeSensor(location: String, sensorType: String = "Smoke Sensor") extends FireSensor(location, sensorType) {

  override def isTriggered(): Boolean = {
    checkBatteryLife()
    drainBattery(20)
    if (Random.nextInt(100) < 10) true else false
  }



}

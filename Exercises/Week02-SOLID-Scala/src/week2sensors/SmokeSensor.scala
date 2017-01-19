package week2sensors

import scala.util.Random

/**
  * Created by nathanhanak on 1/18/17.
  */
class SmokeSensor(override val location: String) extends FireSensor(location) {

  private val sensorType: String = "Smoke sensor"

  override def isTriggered(): Boolean = {
    checkBatteryLife()
    drainBattery(20)
    if (Random.nextInt(100) < 10) true else false
  }



}


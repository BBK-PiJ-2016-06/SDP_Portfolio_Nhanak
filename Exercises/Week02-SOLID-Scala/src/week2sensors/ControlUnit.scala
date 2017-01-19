package week2sensors

import scala.collection.mutable.ArrayBuffer

/**
  * Created by nathanhanak on 1/19/17.
  */
class ControlUnit {

  def pollSensors(): Unit = {
    val fs1 : Sensor = new FireSensor("Basement")
    val ss1 : Sensor = new SmokeSensor("Auditorium")
    val sensors = ArrayBuffer(fs1, ss1)

    for ( s <- sensors ) {
      if (s.isTriggered() ) println(s"A ${s.getSensorType()} sensor was triggered at ${s.getLocation()}")
      else println("Polled ${s.getSensorType} at ${s.getLocation} successfully")
    }
  }

}


/** #3. Currently, pollSensors responsibilities are to create a list of sensors, fill it, and then check
       if they've been triggered

  */
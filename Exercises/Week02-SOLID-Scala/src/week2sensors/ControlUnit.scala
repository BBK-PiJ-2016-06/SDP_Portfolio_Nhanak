package week2sensors

import java.util.ArrayList;
import java.util.List;

/**
  * Created by nathanhanak on 1/19/17.
  */
class ControlUnit {

  public void ControlUnit

  def pollSensors(): Unit = {
    List[Sensor] sensors = new ArrayList[Sensor]
    sensors.add(new FireSensor("Basement"))
    sensors.add(new SmokeSensor("Auditorium"))

    for ( s <- sensors ) {
      if (s.isTriggered() ) println(s"A ${s.getSensorType} sensor was triggered at ${s.getLocation}")
      else println("Polled ${s.getSensorType} at ${s.getLocation} successfully")
    }
  }

}


/** #3. Currently, pollSensors responsibilities are to create a list of sensors, fill it, and then check
       if they've been triggered

  */
package week2sensors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nathanhanak on 1/19/17.
 */

public class ControlUnit {

    public void pollSensors() {
        List<Sensor> sensors = new ArrayList<Sensor>();
        sensors.add(new FireSensor("Basement"));
        sensors.add(new SmokeSensor("Auditorium"));

        for (Sensor sensor : sensors) {
            if (sensor.isTriggered()) {
                System.out.println("A " + sensor.getSensorType() + " sensor was triggered at " + sensor.getLocation());
            } else {
                System.out.println("Polled " + sensor.getSensorType() + " at " + sensor.getLocation() + " successfully");
            }
        }
    }
}
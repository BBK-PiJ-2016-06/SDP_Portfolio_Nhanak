package week2sensors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nathanhanak on 1/19/17.
 */

public class ControlUnit {

    List<Sensor> sensorList = new ArrayList<>();

    public void pollSensors() {

        for (Sensor sensor : sensorList) {
            if (sensor.isTriggered()) {
                System.out.println("A " + sensor.getSensorType() + " sensor was triggered at " + sensor.getLocation());
            } else {
                System.out.println("Polled " + sensor.getSensorType() + " at " + sensor.getLocation() + " successfully");
            }
        }
    }

    public void addSensorToUnit(Sensor newSensor) {
        sensorList.add(newSensor);
    }

    public List<Sensor> getSensorList() {
        return sensorList;
    }
}
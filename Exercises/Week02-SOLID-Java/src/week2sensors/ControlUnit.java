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

/** #3. Currently, pollSensors responsibilities are to create a list of sensors, fill it, and then iterates
 *  through the new list and see if they've been triggered

    #5. Now pollSensors only iterates through the list to see if it's triggered.

    #6. The get battery percentage method is now redundant. It violates the Single Responsibility
        Principle. There's a change in requirements and now I'd have to change all the classes if I made a change
        to that interface. Instead, I will create an extension of Sensor as HazardSensor and change the extensions of
        the resulting sub classes.
 */
package week2sensors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by nathanhanak on 1/19/17.
 */
public class FireSensor implements HazardSensor {

    private Double batteryPercentage = 100.0;
    private String sensorType = "Fire Sensor";
    private String location;
    private List<TriggeredResponse> responses;


    public FireSensor(String location, List<TriggeredResponse> responses) {
        this.responses = responses;
        this.location = location;
    }

    @Override
    public boolean isTriggered() {
        if (getBatteryPercentage() < 10) {
            throw new IllegalStateException("Battery too low to perform operation");
        }
        batteryPercentage -= 10;
        double random = ThreadLocalRandom.current().nextDouble(0, 100);
        boolean triggered = ( random < 10);
        if (triggered) {
            executeSensorResponses();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String getSensorType() {
        return sensorType;
    }

    @Override
    public double getBatteryPercentage() {
        return batteryPercentage;
    }

    private void executeSensorResponses() {
        if (!responses.equals(null)) {
            for (TriggeredResponse t : responses) {
                System.out.println(t.performResponse(getSensorType(), getLocation()));
            }
        }
    }
}
package week2sensors;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by nathanhanak on 1/19/17.
 */
public class FireSensor implements HazardSensor {

    private Double batteryPercentage = 100.0;
    private String sensorType = "Fire Sensor";
    private String location;


    public FireSensor(String location) {
        this.location = location;
    }

    @Override
    public boolean isTriggered() {
        if (getBatteryPercentage() < 10) {
            throw new IllegalStateException("Battery too low to perform operation");
        }
        batteryPercentage -= 10;
        double random = ThreadLocalRandom.current().nextDouble(0, 100);
        return ( random < 5);
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
}
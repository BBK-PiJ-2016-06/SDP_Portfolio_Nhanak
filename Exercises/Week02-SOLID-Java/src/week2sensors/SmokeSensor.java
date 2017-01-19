package week2sensors;

import java.util.concurrent.ThreadLocalRandom;

public class SmokeSensor implements HazardSensor {

    private Double batteryPercentage = 100.0;
    private String sensorType = "Smoke Sensor";
    private String location;


    public SmokeSensor(String location) {
        this.location = location;
    }

    @Override
    public boolean isTriggered() {
        if (getBatteryPercentage() < 20) {
            throw new IllegalStateException("Battery too low to perform operation");
        }
        batteryPercentage -= 20;
        double random = ThreadLocalRandom.current().nextDouble(0, 100);
        return ( random < 10);
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
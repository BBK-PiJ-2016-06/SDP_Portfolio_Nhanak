package week2sensors;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SmokeSensor implements HazardSensor {

    private Double batteryPercentage = 100.0;
    private String sensorType = "Smoke Sensor";
    private String location;
    private List<TriggeredResponse> responses;


    public SmokeSensor(String location, List<TriggeredResponse> responses) {
        this.responses = responses;
        this.location = location;
    }

    @Override
    public boolean isTriggered() {
        if (getBatteryPercentage() < 20) {
            throw new IllegalStateException("Battery too low to perform operation");
        }
        batteryPercentage -= 20;
        double random = ThreadLocalRandom.current().nextDouble(0, 100);
        boolean triggered = ( random < 20);
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
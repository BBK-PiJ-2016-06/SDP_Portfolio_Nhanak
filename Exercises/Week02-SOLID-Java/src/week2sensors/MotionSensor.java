package week2sensors;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by nathanhanak on 1/19/17.
 */
public class MotionSensor implements SecuritySensor {

    private String sensorType = "Motion Sensor";
    private String location;

    public MotionSensor(String location) {
        this.location = location;
    }

    @Override
    public boolean isTriggered() {
        double random = ThreadLocalRandom.current().nextDouble(0, 100);
        return ( random < 15);
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String getSensorType() {
        return sensorType;
    }
}

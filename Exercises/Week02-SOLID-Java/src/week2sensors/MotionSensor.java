package week2sensors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Objects.requireNonNull;

/**
 * Created by nathanhanak on 1/19/17.
 */
public class MotionSensor implements SecuritySensor {

    private String sensorType = "Motion Sensor";
    private String location;
    private List<TriggeredResponse> responses;

    public MotionSensor(String location, List<TriggeredResponse> responses) {
        this.responses = responses;
        this.location = location;
    }

    @Override
    public boolean isTriggered() {
        double random = ThreadLocalRandom.current().nextDouble(0, 100);
        boolean triggered = ( random < 15);
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

    private void executeSensorResponses() {
        if (!responses.equals(null)) {
            for (TriggeredResponse t : responses) {
                System.out.println(t.performResponse(getSensorType(), getLocation()));
            }
        }
    }


}

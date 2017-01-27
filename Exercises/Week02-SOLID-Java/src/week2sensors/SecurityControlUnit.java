package week2sensors;

import java.time.LocalTime;
import java.util.List;

/**
 * Created by nathanhanak on 1/23/17.
 */
public class SecurityControlUnit extends ControlUnit {

    public SecurityControlUnit(List<Sensor> sensorList) {
        super(sensorList);
    }

    @Override
    public void pollSensors() {
        if(timeToCheck()) {
            super.pollSensors();
        } else {
            System.out.println("Security Sensors not activated at " + LocalTime.now().toString());
        }
    }


    private boolean timeToCheck() {
        if (LocalTime.now().isBefore(LocalTime.of(6,00)) || LocalTime.now().isAfter(LocalTime.of(22,00)) ) {
            return true;
        } else {
            return false;
        }
    }


}

/* We are maintaining the open-closed principle when using this method. We are preventing Control Unit from
    becoming too complicated and overburdened. Because it is simple, it is easy to extend and modify the later
    versions.
 */

package week2sensors;

/**
 * Created by nathanhanak on 1/19/17.
 */
public interface Sensor {
    boolean isTriggered();

    String getLocation();

    String getSensorType();

    double getBatteryPercentage();
}
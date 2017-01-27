package week2sensors.TriggeredResponses;

import week2sensors.TriggeredResponse;

import java.time.LocalTime;

/**
 * Created by nathanhanak on 1/23/17.
 */
public class ReleaseAttackDogs implements TriggeredResponse {

    private String action= " released attack dogs at ";

    @Override
    public String performResponse(String alarmType, String alarmLocation) {
        return alarmType + " at " + alarmLocation + action + LocalTime.now().toString();
    }

}

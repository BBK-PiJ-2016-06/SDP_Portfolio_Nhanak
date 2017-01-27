package week2sensors;

import org.junit.Before;
import org.junit.Test;
import week2sensors.TriggeredResponses.NotifyUserSMS;
import week2sensors.TriggeredResponses.ReleaseAttackDogs;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by nathanhanak on 1/23/17.
 */
public class SecurityControlUnitTest {

    private ControlUnit controlUnit;
    MotionSensor motionSensor1;
    MotionSensor motionSensor2;
    List<Sensor> sensorList = new ArrayList<>();
    List<TriggeredResponse> responses = new ArrayList<>();
    TriggeredResponse dogs = new ReleaseAttackDogs();
    TriggeredResponse sms = new NotifyUserSMS();

    @Before
    public void SetUp(){
        responses.add(dogs);
        responses.add(sms);
        controlUnit = new SecurityControlUnit(sensorList);
        motionSensor1 = new MotionSensor("Basement", responses);
        motionSensor2 = new MotionSensor("Armory", responses);
    }

    @Test
    public void testsNewControlUnitContainsEmptySensorsList() {
        assertTrue(controlUnit.getSensorList().isEmpty());
    }

    @Test
    public void testsNewControlUnitSensorListContainsExpectedSensorsAfterAdding() {
        controlUnit.addSensorToSensorList(motionSensor1);
        controlUnit.addSensorToSensorList(motionSensor2);
        assertTrue(controlUnit.getSensorList().contains(motionSensor1));
        assertTrue(controlUnit.getSensorList().contains(motionSensor2));
    }

    /*
    @Test
    public void testsSecurityControlUnitWillNotPollSensorsForATimeOutsideOf10PMTo6AM() {
        // do an if/then. If Current time is in the range of 6am-9:59PM, then assertFalse
        // otherwise assertTrue
        String
        if ( LocalTime.now().isAfter(LocalTime.of(22,00)) ) {
            boolean triggeredAtLeastOnce = false;
            while(int i = 0; i < 1000; i++) {
                if (controlUnit.pollSensors()) {
                    triggeredAtLeastOnce = true;
                }
            }
            assertTrue(triggeredAtLeastOnce);
        }
    */




}

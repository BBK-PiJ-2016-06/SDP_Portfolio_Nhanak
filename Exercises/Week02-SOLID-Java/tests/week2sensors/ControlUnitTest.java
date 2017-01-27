package week2sensors;

import org.junit.Before;
import org.junit.Test;
import week2sensors.TriggeredResponses.NotifyUserSMS;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by nathanhanak on 1/19/17.
 */
public class ControlUnitTest {

    private ControlUnit controlUnit;
    FireSensor fireSensor1;
    SmokeSensor smokeSensor1;
    List<Sensor> sensorList = new ArrayList<>();
    List<TriggeredResponse> responses = new ArrayList<>();
    TriggeredResponse sms = new NotifyUserSMS();

    @Before
    public void SetUp(){
        responses.add(sms);
        controlUnit = new ControlUnit(sensorList);
        fireSensor1 = new FireSensor("Basement", responses);
        smokeSensor1 = new SmokeSensor("Armory", responses);
    }

    @Test
    public void testsNewControlUnitContainsEmptySensorsList() {
        assertTrue(controlUnit.getSensorList().isEmpty());
    }

    @Test
    public void testsNewControlUnitSensorListContainsExpectedSensorsAfterAdding() {
        controlUnit.addSensorToSensorList(fireSensor1);
        controlUnit.addSensorToSensorList(smokeSensor1);
        assertTrue(controlUnit.getSensorList().contains(fireSensor1));
        assertTrue(controlUnit.getSensorList().contains(smokeSensor1));
    }

    @Test
    public void testsPollSensorsDrainsEachSensorAsExpected() {
        controlUnit.addSensorToSensorList(fireSensor1);
        controlUnit.addSensorToSensorList(smokeSensor1);
        controlUnit.pollSensors();
        assertEquals(90, fireSensor1.getBatteryPercentage(), 0.01);
        assertEquals(80, smokeSensor1.getBatteryPercentage(), 0.01);
    }
}

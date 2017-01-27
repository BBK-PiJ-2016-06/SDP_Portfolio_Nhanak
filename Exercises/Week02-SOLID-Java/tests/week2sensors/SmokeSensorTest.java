package week2sensors;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import week2sensors.TriggeredResponses.NotifyUserSMS;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SmokeSensorTest {

    List<TriggeredResponse> responses = new ArrayList<>();
    TriggeredResponse sms = new NotifyUserSMS();

    @Before
    public void SetUp() {
        responses.add(sms);
    }
    @Ignore
    @Test
    public void testThatIsTriggeredReturnsFalse() {
        SmokeSensor sensor = new SmokeSensor("Basement", responses);
        boolean isTriggered = sensor.isTriggered();
        assertEquals(false, isTriggered);
    }

    @Test
    public void testThatGetLocationReturnsOriginalLocation() {
        String expected = "Auditorium";
        SmokeSensor sensor = new SmokeSensor("Auditorium", responses);
        String location = sensor.getLocation();
        assertEquals(expected, location);
    }

    @Test
    public void testThatGetSensorTypeReturnsSmokeSensor() {
        SmokeSensor sensor = new SmokeSensor("Ceiling", responses);
        String sensorType = sensor.getSensorType();
        assertEquals("Smoke Sensor", sensorType);
    }

    @Test
    public void testThatGetBatteryPercentageReturns100() {
        SmokeSensor sensor = new SmokeSensor("Bathroom", responses);
        Double batteryPercentage = sensor.getBatteryPercentage();
        assertEquals(100.0, batteryPercentage, .1);
    }

    @Test
    public void testThatIsTriggeredDecreasesBatteryPercentageByTwenty() {
        SmokeSensor sensor = new SmokeSensor("Outside", responses);
        sensor.isTriggered();
        Double batteryPercentage = sensor.getBatteryPercentage();
        assertEquals(80, batteryPercentage, .1);
    }

    @Test
    public void testThatIsTriggeredThrowsExceptionWhenCalled6Times() {
        boolean exceptionThrown = false;
        SmokeSensor sensor = new SmokeSensor("Bedroom", responses);
        try {
            for(int i = 0; i<6; i++ ) {
                sensor.isTriggered();
            }
        } catch (IllegalStateException ex) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void testIfTriggeredReturnsTrueEventually() {
        boolean trueAtLeastOnce = false;
        while(!trueAtLeastOnce) {
            SmokeSensor sensor = new SmokeSensor("Laundry Room", responses);
            if (sensor.isTriggered()){
                trueAtLeastOnce = true;
            }
        }
        assertTrue(trueAtLeastOnce);
    }

}
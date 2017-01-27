package week2sensors;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import week2sensors.TriggeredResponses.NotifyFireBrigade;
import week2sensors.TriggeredResponses.NotifyUserSMS;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FireSensorTest {

    private List<TriggeredResponse> responses = new ArrayList<>();
    private TriggeredResponse fire = new NotifyFireBrigade();
    private TriggeredResponse sms = new NotifyUserSMS();

    @Before
    public void setUp(){
        responses.add(fire);
        responses.add(sms);
    }



    @Ignore
    @Test
    public void testThatIsTriggeredReturnsFalse() {
        FireSensor sensor = new FireSensor("Basement", responses);
        boolean isTriggered = sensor.isTriggered();
        assertEquals(false, isTriggered);
    }

    @Test
    public void testThatGetLocationReturnsOriginalLocation() {
        String expected = "Auditorium";
        FireSensor sensor = new FireSensor("Auditorium", responses);
        String location = sensor.getLocation();
        assertEquals(expected, location);
    }

    @Test
    public void testThatGetSensorTypeReturnsFireSensor() {
        FireSensor sensor = new FireSensor("Ceiling", responses);
        String sensorType = sensor.getSensorType();
        assertEquals("Fire Sensor", sensorType);
    }

    @Test
    public void testThatGetBatteryPercentageReturns100() {
        FireSensor sensor = new FireSensor("Bathroom", responses);
        double batteryPercentage = sensor.getBatteryPercentage();
        assertEquals(100, batteryPercentage, .1);
    }

    @Test
    public void testThatIsTriggeredDecreasesBatteryPercentageByTen() {
        FireSensor sensor = new FireSensor("Outside", responses);
        sensor.isTriggered();
        double batteryPercentage = sensor.getBatteryPercentage();
        assertEquals(90, batteryPercentage, .1);
    }

    @Test
    public void testThatIsTriggeredThrowsExceptionWhenCalled11Times() {
        boolean exceptionThrown = false;
        FireSensor sensor = new FireSensor("Bedroom", responses);
        try {
            for(int i = 0; i<11; i++ ) {
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
            FireSensor sensor = new FireSensor("Laundry Room", responses);
            if (sensor.isTriggered()){
                trueAtLeastOnce = true;
            }
        }
        assertTrue(trueAtLeastOnce);
    }

}
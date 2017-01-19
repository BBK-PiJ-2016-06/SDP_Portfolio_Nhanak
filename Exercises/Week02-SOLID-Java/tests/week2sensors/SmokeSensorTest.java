package week2sensors;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SmokeSensorTest {

    @Ignore
    @Test
    public void testThatIsTriggeredReturnsFalse() {
        SmokeSensor sensor = new SmokeSensor("Basement");
        boolean isTriggered = sensor.isTriggered();
        assertEquals(false, isTriggered);
    }

    @Test
    public void testThatGetLocationReturnsOriginalLocation() {
        String expected = "Auditorium";
        SmokeSensor sensor = new SmokeSensor("Auditorium");
        String location = sensor.getLocation();
        assertEquals(expected, location);
    }

    @Test
    public void testThatGetSensorTypeReturnsSmokeSensor() {
        SmokeSensor sensor = new SmokeSensor("Ceiling");
        String sensorType = sensor.getSensorType();
        assertEquals("Smoke Sensor", sensorType);
    }

    @Test
    public void testThatGetBatteryPercentageReturns100() {
        SmokeSensor sensor = new SmokeSensor("Bathroom");
        Double batteryPercentage = sensor.getBatteryPercentage();
        assertEquals(100.0, batteryPercentage, .1);
    }

    @Test
    public void testThatIsTriggeredDecreasesBatteryPercentageByTwenty() {
        SmokeSensor sensor = new SmokeSensor("Outside");
        sensor.isTriggered();
        Double batteryPercentage = sensor.getBatteryPercentage();
        assertEquals(80, batteryPercentage, .1);
    }

    @Test
    public void testThatIsTriggeredThrowsExceptionWhenCalled6Times() {
        boolean exceptionThrown = false;
        SmokeSensor sensor = new SmokeSensor("Bedroom");
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
            SmokeSensor sensor = new SmokeSensor("Laundry Room");
            if (sensor.isTriggered()){
                trueAtLeastOnce = true;
            }
        }
        assertTrue(trueAtLeastOnce);
    }

}
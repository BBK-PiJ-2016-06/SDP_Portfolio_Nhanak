package week2sensors;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FireSensorTest {

    @Ignore
    @Test
    public void testThatIsTriggeredReturnsFalse() {
        FireSensor sensor = new FireSensor("Basement");
        boolean isTriggered = sensor.isTriggered();
        assertEquals(false, isTriggered);
    }

    @Test
    public void testThatGetLocationReturnsOriginalLocation() {
        String expected = "Auditorium";
        FireSensor sensor = new FireSensor("Auditorium");
        String location = sensor.getLocation();
        assertEquals(expected, location);
    }

    @Test
    public void testThatGetSensorTypeReturnsFireSensor() {
        FireSensor sensor = new FireSensor("Ceiling");
        String sensorType = sensor.getSensorType();
        assertEquals("Fire Sensor", sensorType);
    }

    @Test
    public void testThatGetBatteryPercentageReturns100() {
        FireSensor sensor = new FireSensor("Bathroom");
        double batteryPercentage = sensor.getBatteryPercentage();
        assertEquals(100, batteryPercentage, .1);
    }

    @Test
    public void testThatIsTriggeredDecreasesBatteryPercentageByTen() {
        FireSensor sensor = new FireSensor("Outside");
        sensor.isTriggered();
        double batteryPercentage = sensor.getBatteryPercentage();
        assertEquals(90, batteryPercentage, .1);
    }

    @Test
    public void testThatIsTriggeredThrowsExceptionWhenCalled11Times() {
        boolean exceptionThrown = false;
        FireSensor sensor = new FireSensor("Bedroom");
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
            FireSensor sensor = new FireSensor("Laundry Room");
            if (sensor.isTriggered()){
                trueAtLeastOnce = true;
            }
        }
        assertTrue(trueAtLeastOnce);
    }

}
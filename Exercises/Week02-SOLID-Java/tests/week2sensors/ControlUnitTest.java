package week2sensors;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by nathanhanak on 1/19/17.
 */
public class ControlUnitTest {

    ControlUnit controlUnit;
    FireSensor fireSensor1;
    SmokeSensor smokeSensor1;

    @Before
    public void SetUp(){
        controlUnit = new ControlUnit();
        fireSensor1 = new FireSensor("Basement");
        smokeSensor1 = new SmokeSensor("Armory");
    }

    @Test
    public void testsNewControlUnitContainsEmptySensorsList() {
        assertTrue(controlUnit.getSensorList().isEmpty());
    }

    @Test
    public void testsNewContolUnitSensorListContainsExpectedSensorsAfterAdding() {
        controlUnit.addSensorToUnit(fireSensor1);
        controlUnit.addSensorToUnit(smokeSensor1);
        assertTrue(controlUnit.getSensorList().contains(fireSensor1));
        assertTrue(controlUnit.getSensorList().contains(smokeSensor1));
    }

}

package week2sensors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nathanhanak on 1/19/17.
 */

public class App {
    private static final String EXIT = "exit";
    private static final String POLL = "poll";

    public static void main(String[] args) throws IOException {
        List<Sensor> constructorList1 = new ArrayList<>();
        List<Sensor> constructorList2 = new ArrayList<>();
        ControlUnit controlUnit = new ControlUnit(constructorList1);
        SecurityControlUnit secControlUnit = new SecurityControlUnit(constructorList2);
        controlUnit.addSensorToSensorList(new FireSensor("Chicken Coop"));
        controlUnit.addSensorToSensorList(new SmokeSensor("Kitchen"));
        secControlUnit.addSensorToSensorList(new MotionSensor("Yard"));


        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals(EXIT)) {
            System.out.println("Type \"poll\" to poll all sensors once or \"exit\" to exit");
            input = scanner.nextLine();
            if (input.equals(POLL)) {
                controlUnit.pollSensors();
                secControlUnit.pollSensors();
            }
        }
    }
}


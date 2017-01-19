package week2sensors;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by nathanhanak on 1/19/17.
 */

public class App {
    private static final String EXIT = "exit";
    private static final String POLL = "poll";

    public static void main(String[] args) throws IOException {
        ControlUnit controlUnit = new ControlUnit();
        controlUnit.addSensorToUnit(new FireSensor("Chicken Coop"));
        controlUnit.addSensorToUnit(new SmokeSensor("Kitchen"));


        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals(EXIT)) {
            System.out.println("Type \"poll\" to poll all sensors once or \"exit\" to exit");
            input = scanner.nextLine();
            if (input.equals(POLL)) {
                controlUnit.pollSensors();
            }
        }
    }
}


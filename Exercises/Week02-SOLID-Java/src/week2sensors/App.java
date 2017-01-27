package week2sensors;

import week2sensors.TriggeredResponses.NotifyFireBrigade;
import week2sensors.TriggeredResponses.NotifyPolice;
import week2sensors.TriggeredResponses.NotifyUserSMS;
import week2sensors.TriggeredResponses.ReleaseAttackDogs;

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
    private static final TriggeredResponse police = new NotifyPolice();
    private static final TriggeredResponse fire = new NotifyFireBrigade();
    private static final TriggeredResponse sms = new NotifyUserSMS();
    private static final TriggeredResponse dogs = new ReleaseAttackDogs();

    public static void main(String[] args) throws IOException {
        List<Sensor> constructorList1 = new ArrayList<>();
        List<Sensor> constructorList2 = new ArrayList<>();
        List<TriggeredResponse> motionSensorResponses = new ArrayList<>();
        motionSensorResponses.add(dogs);
        motionSensorResponses.add(police);
        motionSensorResponses.add(sms);
        List<TriggeredResponse> smokeResponses = new ArrayList<>();
        smokeResponses.add(sms);
        List<TriggeredResponse> fireResponse = new ArrayList<>();
        fireResponse.add(fire);
        fireResponse.add(sms);

        ControlUnit controlUnit = new ControlUnit(constructorList1);
        SecurityControlUnit secControlUnit = new SecurityControlUnit(constructorList2);
        controlUnit.addSensorToSensorList(new FireSensor("Chicken Coop", fireResponse));
        controlUnit.addSensorToSensorList(new SmokeSensor("Kitchen", smokeResponses));
        secControlUnit.addSensorToSensorList(new MotionSensor("Yard", motionSensorResponses));


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


package notebook.controller;

import java.io.InputStream;
import java.util.Scanner;

public class ViewDataController {

    private static String INPUT_DATA = "Input %s = ";
    private static String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";
    private static String USER_DATA = "Current user data: \n";
    private static String USER_QUESTION = " %s is not obligatory. Do you want to input value?(1 - yes, 2 or other - no)";
    private static String USER_ADDRESS_QUESTION = "Do you want to input one more address?(1 - yes, 2 or other - no)";
    private Scanner in;

    public ViewDataController(InputStream in) {
        this.in = new Scanner(in);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    public void printInputFieldData(String fieldName) {
        printMessage(String.format(INPUT_DATA, fieldName));
    }

    public void printWrongInputData(String fieldName) {
        printMessage(WRONG_INPUT_DATA + String.format(INPUT_DATA, fieldName));
    }

    public void printAllUserData(String userData) {
        printMessage(USER_DATA + userData);
    }

    public boolean receiveAnswerAboutInputValue(String fieldName) {
        printMessage(String.format(USER_QUESTION, fieldName));
        int answer = in.nextInt();
        return answer == 1;
    }

    public boolean receiveAnswerAboutInputNewAddress() {
        printMessage(USER_ADDRESS_QUESTION);
        int answer = in.nextInt();
        return answer == 1;
    }

    public String inputStringValue(String fieldName) {

        while (!in.hasNext()) {
            printWrongInputData(fieldName);
        }
        return in.next();
    }

}

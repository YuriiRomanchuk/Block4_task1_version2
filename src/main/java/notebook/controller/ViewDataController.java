package notebook.controller;

import java.io.InputStream;
import java.util.Scanner;

public class ViewDataController {

    private static final String INPUT_DATA = "Input %s = ";
    private static final String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";
    private static final String USER_DATA = "Current user data: \n";
    private static final String USER_QUESTION = " %s is not obligatory. Do you want to input value?(1 - yes, 2 or other - no)";
    private static final String USER_ADDRESS_QUESTION = "Do you want to input one more address?(1 - yes, 2 or other - no)";
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
        return in.nextLine();
    }

    public int inputIntValue(String fieldName) {
        while (!in.hasNextInt()) {
            printWrongInputData(fieldName);
            in.next();
        }
        return in.nextInt();
    }

}

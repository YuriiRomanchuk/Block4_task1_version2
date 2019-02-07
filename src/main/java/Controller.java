package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Controller {

    private Model model;
    private View view;
    private List<String> stringRestrictions;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        stringRestrictions = view.receiveStringRestrictions();
    }

    public void processUser() {

        Scanner in = new Scanner(System.in);
        boolean startProgram = true;

        while (startProgram) {

            String currentValue = model.getValue();

            if (currentValue.isEmpty()) {
                model.setValue(inputStringValueWithScanner(in));
            } else {
                model.addCurrentStringValue(inputStringValueWithScanner(in));
            }

            String matchString = stringRestrictions.stream().collect(Collectors.joining(" "));

            if (matchString.equals(model.getValue())) {
                startProgram = false;
            }
        }

        view.printMessageAndValue(view.CURRENT_STRING, model.getValue());

    }

    private String inputStringValueWithScanner(Scanner in) {

        String currentValue = model.getValue();
        String inputValue = stringRestrictions.get(0);

        if (!currentValue.isEmpty()) {
            List<String> currentValueList = Arrays.asList(currentValue.split(" "));
            inputValue = stringRestrictions.stream().filter(s -> !currentValueList.contains(s)).findFirst().get();
        }

        view.printMessage(View.INPUT_STRING_DATA + inputValue);

        while (!in.hasNext(inputValue)) {
            view.printMessage(View.WRONG_INPUT_STRING_DATA + View.INPUT_STRING_DATA + inputValue);
            in.nextLine();
        }
        return in.nextLine();
    }

}

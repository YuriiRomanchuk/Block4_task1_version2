package notebook.initializer;

import notebook.controller.ViewDataController;
import notebook.model.UserDataAddress;
import notebook.model.UserDataModel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class AddressInitializer implements FieldInitializer<UserDataModel> {

    private final String address;
    private final ViewDataController viewDataController;
    private final List<FieldInitializer> receiveAddressFieldInitializer;
    private final BiConsumer<UserDataModel, List<UserDataAddress>> setUserDataAddresses;

    public AddressInitializer(String address, ViewDataController viewDataController, List<FieldInitializer> receiveAddressFieldInitializer, BiConsumer<UserDataModel, List<UserDataAddress>> setUserDataAddresses) {
        this.address = address;
        this.viewDataController = viewDataController;
        this.receiveAddressFieldInitializer = receiveAddressFieldInitializer;
        this.setUserDataAddresses = setUserDataAddresses;
    }

    @Override
    public void initialize(UserDataModel userDataModel) {

        List<UserDataAddress> userDataAddresses = new ArrayList<>();

        boolean continueCreateAddress = true;
        while (continueCreateAddress) {
            UserDataAddress userDataAddress = new UserDataAddress();
            for (FieldInitializer fieldInitializer : receiveAddressFieldInitializer) {
                fieldInitializer.initialize(userDataAddress);
            }
            userDataAddresses.add(userDataAddress);

            if (!viewDataController.receiveAnswerAboutInputNewAddress()) {
                continueCreateAddress = false;
            }
        }
        setUserDataAddresses.accept(userDataModel, userDataAddresses);
    }
}

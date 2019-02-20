package notebook.initializer;

import notebook.controller.ViewDataController;
import notebook.model.UserAddress;
import notebook.model.UserData;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class AddressInitializer implements FieldInitializer<UserData> {

    private final String address;
    private final ViewDataController viewDataController;
    private final List<FieldInitializer<UserAddress>> receiveAddressFieldInitializer;
    private final BiConsumer<UserData, List<UserAddress>> setUserDataAddresses;

    public AddressInitializer(String address, ViewDataController viewDataController, List<FieldInitializer<UserAddress>> receiveAddressFieldInitializer, BiConsumer<UserData, List<UserAddress>> setUserDataAddresses) {
        this.address = address;
        this.viewDataController = viewDataController;
        this.receiveAddressFieldInitializer = receiveAddressFieldInitializer;
        this.setUserDataAddresses = setUserDataAddresses;
    }

    @Override
    public void initialize(UserData userData) {

        List<UserAddress> userAddresses = new ArrayList<>();

        boolean continueCreateAddress = true;
        while (continueCreateAddress) {
            viewDataController.printInputFieldData(address);
            UserAddress userAddress = new UserAddress();
            for (FieldInitializer fieldInitializer : receiveAddressFieldInitializer) {
                fieldInitializer.initialize(userAddress);
            }
            userAddresses.add(userAddress);

            continueCreateAddress = viewDataController.receiveAnswerAboutInputNewAddress();

        }
        setUserDataAddresses.accept(userData, userAddresses);
    }
}

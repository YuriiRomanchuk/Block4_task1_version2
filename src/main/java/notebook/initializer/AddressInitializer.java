package notebook.initializer;

import notebook.controller.ViewDataController;
import notebook.model.UserAddress;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class AddressInitializer<T> implements FieldInitializer<T> {

    private final String address;
    private final ViewDataController viewDataController;
    private final List<FieldInitializer<UserAddress>> receiveAddressFieldInitializer;
    private final BiConsumer<T, List<UserAddress>> setUserDataAddresses;

    public AddressInitializer(String address, ViewDataController viewDataController, List<FieldInitializer<UserAddress>> receiveAddressFieldInitializer, BiConsumer<T, List<UserAddress>> setUserDataAddresses) {
        this.address = address;
        this.viewDataController = viewDataController;
        this.receiveAddressFieldInitializer = receiveAddressFieldInitializer;
        this.setUserDataAddresses = setUserDataAddresses;
    }

    @Override
    public void initialize(T userData) {

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

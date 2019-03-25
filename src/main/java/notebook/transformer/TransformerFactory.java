package notebook.transformer;

import notebook.model.dto.UserAddressDto;
import notebook.model.dto.UserDataDto;

import javax.servlet.http.HttpServletRequest;

public class TransformerFactory {

    private HttpServletRequest request;
    private UserAddressTransformer userAddressTransformer;
    private UserDataTransformer userDataTransformer;

    public TransformerFactory(HttpServletRequest request) {
        this.request = request;
        this.userAddressTransformer = new UserAddressTransformer();
        this.userDataTransformer = new UserDataTransformer();
    }

    public UserDataDto receiveUserData() {
        UserDataDto userDataDto = userDataTransformer.transformToObject(request);
        UserAddressDto userAddressDto = userAddressTransformer.transformToObject(request);
        userDataDto.fillUserAddresses(userAddressDto);
        return userDataDto;
    }

}

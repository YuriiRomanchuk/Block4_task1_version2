package notebook.transformer;

import notebook.model.dto.UserDataDto;

import javax.servlet.http.HttpServletRequest;

public class UserDataTransformer implements Transformer {
    @Override
    public UserDataDto transformToObject(HttpServletRequest request) {
        return null;
    }
}

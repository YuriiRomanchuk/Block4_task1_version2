package notebook.model;

import notebook.exception.fieldFillingException;

import java.util.Arrays;

public class SqlConnector {

    private UserDataModel userDataModel;
    private String[] occupiedNicknames = {"anybis", "petro666", "ybivatel"};

    public SqlConnector(UserDataModel userDataModel) {
        this.userDataModel = userDataModel;
    }


    public void verifyNickname() throws fieldFillingException{

        long count = Arrays.stream(occupiedNicknames).filter(s -> s.equals(userDataModel.getNickname())).count();

        if (count != 0l) {
            throw new fieldFillingException("Current nick name is busy!", "nickname");
        }
    }


}

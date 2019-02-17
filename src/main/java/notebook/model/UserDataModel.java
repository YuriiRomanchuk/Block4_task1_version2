package notebook.model;


import notebook.currentEnum.Groups;

import java.util.List;

public class UserDataModel {

    private String lastName;
    private String firstName;
    private String middleName;
    private String fullName;
    private String nickname;
    private String comment;
    private Groups groupName;
    private String skype;
    private String email;
    private String homePhoneNumber;
    private String mobilePhoneNumber;
    private String mobilePhoneNumberSecond;
    private String entryDate;
    private String DateOfLastChange;
    private List<UserDataAddress> userDataAddresses;

    public void setUserDataAddresses(List<UserDataAddress> userDataAddresses) {
        this.userDataAddresses = userDataAddresses;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setGroupName(Groups groupName) {
        this.groupName = groupName;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public void setMobilePhoneNumberSecond(String mobilePhoneNumberSecond) {
        this.mobilePhoneNumberSecond = mobilePhoneNumberSecond;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public void setDateOfLastChange(String dateOfLastChange) {
        DateOfLastChange = dateOfLastChange;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }


    @Override
    public String toString() {
        return "UserDataModel{" + "\n" +
                "lastName='" + lastName + '\'' + "\n" +
                ", firstName='" + firstName + '\'' + "\n" +
                ", middleName='" + middleName + '\'' + "\n" +
                ", fullName='" + fullName + '\'' + "\n" +
                ", nickname='" + nickname + '\'' + "\n" +
                ", comment='" + comment + '\'' + "\n" +
                ", groupName=" + groupName + "\n" +
                ", skype='" + skype + '\'' + "\n" +
                ", email='" + email + '\'' + "\n" +
                ", homePhoneNumber='" + homePhoneNumber + '\'' + "\n" +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' + "\n" +
                ", mobilePhoneNumberSecond='" + mobilePhoneNumberSecond + '\'' + "\n" +
                ", entryDate='" + entryDate + '\'' + "\n" +
                ", DateOfLastChange='" + DateOfLastChange + '\'' + "\n" +
                ", userDataAddresses='" + "\n" + userDataAddresses + '\'' + "\n" +
                '}';
    }

}


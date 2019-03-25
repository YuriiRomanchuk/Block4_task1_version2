package notebook.model;


import notebook.currentEnum.Groups;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserData {

    private int id;
    private String lastName = "";
    private String firstName = "";
    private String middleName = "";
    private String fullName = "";
    private String nickname = "";
    private String comment = "";
    private Groups groupName;
    private String skype = "";
    private String email = "";
    private String homePhoneNumber = "";
    private String mobilePhoneNumber = "";
    private String mobilePhoneNumberSecond = "";
    private Date entryDate;
    private Date dateOfLastChange;
    private List<UserAddress> userAddresses = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void fillUserAddresses(UserAddress userAddresses) {
        this.userAddresses.add(userAddresses);
    }

    public void setUserAddresses(List<UserAddress> userAddresses) {
        this.userAddresses = userAddresses;
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

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public void setDateOfLastChange(Date dateOfLastChange) {
        this.dateOfLastChange = dateOfLastChange;
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

    public String getFullName() {
        return fullName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getComment() {
        return comment;
    }

    public Groups getGroupName() {
        return groupName;
    }

    public String getSkype() {
        return skype;
    }

    public String getEmail() {
        return email;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getMobilePhoneNumberSecond() {
        return mobilePhoneNumberSecond;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public Date getDateOfLastChange() {
        return dateOfLastChange;
    }

    public List<UserAddress> getUserAddresses() {
        return userAddresses;
    }

    @Override
    public String toString() {
        return "UserData{" + "\n" +
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
                ", dateOfLastChange='" + dateOfLastChange + '\'' + "\n" +
                ", userAddresses='" + "\n" + userAddresses + '\'' + "\n" +
                '}';
    }

}


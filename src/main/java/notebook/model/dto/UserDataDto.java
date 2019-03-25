package notebook.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDataDto {

    private String lastName;
    private String firstName;
    private String middleName;
    private String fullName;
    private String nickname;
    private String comment;
    private String groupName;
    private String skype;
    private String email;
    private String homePhoneNumber;
    private String mobilePhoneNumber;
    private String mobilePhoneNumberSecond;
    private Date entryDate;
    private Date dateOfLastChange;
    private List<UserAddressDto> userAddresses = new ArrayList<>();


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

    public String getGroupName() {
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

    public List<UserAddressDto> getUserAddresses() {
        return userAddresses;
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

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setGroupName(String groupName) {
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

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public void setDateOfLastChange(Date dateOfLastChange) {
        this.dateOfLastChange = dateOfLastChange;
    }

    public void setUserAddresses(List<UserAddressDto> userAddresses) {
        this.userAddresses = userAddresses;
    }

    public void fillUserAddresses(UserAddressDto userAddress) {
        this.userAddresses.add(userAddress);
    }
}

package notebook.model;

public class UserDataAddress {

    private int index;
    private String city;
    private String street;
    private String houseNumber;
    private int flatNumber;

    public void setIndex(int index) {
        this.index = index;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    @Override
    public String toString() {
        return "UserDataAddress{" + "\n" +
                "index='" + index + '\'' + "\n" +
                ", city='" + city + '\'' + "\n" +
                ", street='" + street + '\'' + "\n" +
                ", houseNumber='" + houseNumber + '\'' + "\n" +
                ", flatNumber='" + flatNumber + '\'' + "\n" +
                '}';
    }
}

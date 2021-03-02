import java.util.Objects;

public class Address {
    private String street;
    private int house;
    private int flat;

    public Address(String street, int house, int flat) {
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getHouse() {
        return house;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public int getFlat() {
        return flat;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Address)) return false;
        Address otherAddress = (Address) obj;
        return street.equals(otherAddress.street) && house == otherAddress.house && flat == otherAddress.flat;
    }

    @Override
     public int hashCode() {
        return Objects.hash(street, house, flat);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street=" + street +
                ", house=" + house +
                ", flat=" + flat +
                '}';
    }

}

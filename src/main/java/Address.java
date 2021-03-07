import java.util.Objects;

interface AddressAll {
    String setStreet(String street);
    String getStreet();
    int setHouse(int house);
    int getHouse();
    int setFlat(int flat);
    int getFlat();
}

public class Address implements AddressAll {
    private String street;
    private int house;
    private int flat;

    public Address(String street, int house, int flat) {
        if (house <= 0 || flat <= 0) throw new IllegalArgumentException("Номер такого дома или квартиры не существует");
            this.street = street;
            this.house = house;
            this.flat = flat;
    }

    public String setStreet(String newStreet) {
        if (newStreet == null || newStreet.length() == 0) throw new IllegalArgumentException("Такой улицы не существует");
        String result = street;
        this.street = newStreet;
        return result;
    }

    public String getStreet() {
        return street;
    }

    public int setHouse(int newHouse) {
        if (newHouse <= 0) throw new IllegalArgumentException("Номер такого дома не существует");
        int result = house;
        this.house = newHouse;
        return result;
    }

    public int getHouse() {
        return house;
    }

    public int setFlat(int newFlat) {
        if (newFlat <= 0) throw new IllegalArgumentException("Номер такой квартиры не существует");
        int result = house;
        this.flat = newFlat;
        return result;
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

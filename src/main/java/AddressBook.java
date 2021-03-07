import java.util.*;

interface AddressBooks {
    HashMap<String, Address> getAdds();
    boolean addPersonAddress(String surname, Address address);
    boolean deletePerson(String surname);
    boolean changePerson(String surname, Address address);
    Address getAddress(String surname);
    List<String> getListPersonStreet(String street);
    List<String> getListPersonStreetAndHouse(String street, int house);
}

public class AddressBook implements AddressBooks {

/**
 Адресная книга.
 Хранит список адресов различных людей. Адрес состоит из улицы,номера дома и номера квартиры. Человек задаётся
 фамилией, для каждого человека хранится лишь один адрес.
 Методы:
1) добавление пары человек-адрес
2) удаление человека
3) изменение адреса человека
4) получение адреса человека
5) получение списка людей, живущих на заданной улице или в заданном доме
**/

    private final HashMap<String, Address> adds = new HashMap<>();

    public HashMap<String, Address> getAdds() {
        return adds;
    }

    public boolean addPersonAddress(String surname, Address address) {
        if (exception(surname)) return false;
        adds.put(surname, address);
        return true;
    }

    public boolean deletePerson(String surname) {
        if (exception(surname)) return false;
        adds.remove(surname);
        return true;
    }

    public boolean changePerson(String surname, Address address) {
        if (exception(surname)) return false;
        adds.put(surname, address);
        return true;
    }

    public Address getAddress(String surname) {
        return adds.get(surname);
    }

    public List<String> getListPersonStreet(String street) {
        List<String> listPersonStreet = new ArrayList<>();
        for (Map.Entry<String, Address> entry : adds.entrySet()) {
            Address address = entry.getValue();
            if (address.getStreet().equals(street)) listPersonStreet.add(entry.getKey());
        }
        return listPersonStreet;
    }

    public List<String> getListPersonStreetAndHouse(String street, int house) {
        List<String> listPersonStreet = new ArrayList<>();
        for (Map.Entry<String, Address> entry : adds.entrySet()) {
            Address address = entry.getValue();
            int numberHouse = entry.getValue().getHouse();
            if (address.getStreet().equals(street) && numberHouse == house) listPersonStreet.add(entry.getKey());
        }
        return listPersonStreet;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Address)) return false;
        AddressBook that = (AddressBook) obj;
        return adds.equals(that.adds);
    }

    @Override
    public int hashCode() {
        return adds.hashCode();
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "adds=" + adds +
                '}';
    }

    private boolean exception(String surname) {
        return surname == null || surname.length() == 0;
    }
}


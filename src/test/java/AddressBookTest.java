import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    final AddressBook mainList = new AddressBook();
    HashMap<String, Address> expectedList = new HashMap<>();
    List<String> expectedListT = new ArrayList<>();
    final Address listOne = new Address("30 лет победы", 43, 17);
    final Address listTwo = new Address("Введенского", 32, 39);
    final Address listThree = new Address("Миклухо-Маклая", 40, 177);
    final Address listFour = new Address("Иосифа Каролинского", 9, 725);


    @Test
    void addPersonAddress() {
        expectedList.put("Сергеев", new Address("30 лет победы", 43, 17));
        expectedList.put("Данилов", new Address("Введенского", 32, 39));
        expectedList.put("Шевцов", new Address("Миклухо-Маклая", 40, 177));
        expectedList.put("Горошко", new Address("Иосифа Каролинского", 9, 725));
        mainList.addPersonAddress("Сергеев", listOne);
        mainList.addPersonAddress("Данилов", listTwo);
        mainList.addPersonAddress("Шевцов", listThree);
        mainList.addPersonAddress("Горошко", listFour);
        assertTrue(mainList.addPersonAddress("Сергеев", listOne));
        assertFalse(mainList.addPersonAddress("", listOne));
        assertEquals(expectedList.entrySet(), mainList.getAdds().entrySet());
        assertThrows(IllegalArgumentException.class, () -> listOne.setHouse(-10));
        assertThrows(IllegalArgumentException.class, () -> listTwo.setFlat(-252));
        assertThrows(IllegalArgumentException.class, () -> listThree.setStreet(null));
    }

    @Test
    void deletePerson() {
        expectedList.put("Сергеев", new Address("30 лет победы", 43, 17));
        expectedList.put("Шевцов", new Address("Миклухо-Маклая", 40, 177));
        mainList.addPersonAddress("Сергеев", listOne);
        mainList.addPersonAddress("Данилов", listTwo);
        mainList.addPersonAddress("Шевцов", listThree);
        mainList.deletePerson("Данилов");
        assertTrue(mainList.deletePerson("Данилов"));
        assertFalse(mainList.deletePerson(null));
        assertEquals(expectedList.entrySet(), mainList.getAdds().entrySet());
    }

    @Test
    void changePerson() {
        expectedList.put("Сергеев", new Address("Ленинский проспект", 86, 478));
        expectedList.put("Данилов", new Address("Липовый парк", 7, 44));
        expectedList.put("Шевцов", new Address("Миклухо-Маклая", 40, 177));
        expectedList.put("Горошко", new Address("Иосифа Каролинского", 9, 725));
        mainList.addPersonAddress("Сергеев", listOne);
        mainList.addPersonAddress("Данилов", listTwo);
        mainList.addPersonAddress("Шевцов", listThree);
        mainList.addPersonAddress("Горошко", listFour);
        mainList.changePerson("Сергеев", new Address("Ленинский проспект", 86, 478));
        mainList.changePerson("Данилов", new Address("Липовый парк", 7, 44));
        assertTrue(mainList.changePerson("Сергеев", new Address("Ленинский проспект", 86, 478)));
        assertFalse(mainList.changePerson("", new Address("Липовый парк", 7, 44)));
        assertEquals(expectedList.entrySet(), mainList.getAdds().entrySet());
    }

    @Test
    void getAddress() {
        mainList.addPersonAddress("Сергеев", new Address("30 лет победы", 43, 17));
        assertEquals(listOne, mainList.getAddress("Сергеев"));
    }

    @Test
    void getListPersonStreet() {
        expectedListT.add("Сергеев");
        expectedListT.add("Данилов");
        mainList.addPersonAddress("Сергеев", new Address("Ленинский проспект", 86, 478));
        mainList.addPersonAddress("Данилов", new Address("Ленинский проспект", 40, 39));
        assertEquals(expectedListT, mainList.getListPersonStreet("Ленинский проспект"));
    }

    @Test
    void getListPersonStreetAndHouse() {
        expectedListT.add("Сергеев");
        mainList.addPersonAddress("Сергеев", new Address("Ленинский проспект", 86, 478));
        mainList.addPersonAddress("Данилов", new Address("Ленинский проспект", 40, 39));
        assertEquals(expectedListT, mainList.getListPersonStreetAndHouse("Ленинский проспект", 86));
    }

    @Test
    void testEquals() {
        AddressBook addsOne = new AddressBook();
        AddressBook addsTwo = new AddressBook();
        addsOne.addPersonAddress("Сергеев", new Address("30 лет победы", 43, 17));
        addsTwo.addPersonAddress("Сергеев", new Address("30 лет победы", 43, 17));
        assertEquals(addsOne.getAdds().entrySet(), addsTwo.getAdds().entrySet());
    }

    @Test
    void testHashCode() {
        AddressBook addsOne = new AddressBook();
        AddressBook addsTwo = new AddressBook();
        addsOne.addPersonAddress("Сергеев", new Address("30 лет победы", 43, 17));
        addsTwo.addPersonAddress("Сергеев", new Address("30 лет победы", 43, 17));
        assertEquals(addsOne.hashCode(), addsTwo.hashCode());
    }

    @Test
    void testToString() {
        AddressBook adds = new AddressBook();
        adds.addPersonAddress("Сергеев", new Address("30 лет победы", 43, 17));
        assertEquals("AddressBook{adds={Сергеев=Address{street=30 лет победы, house=43, flat=17}}}", adds.toString());
    }
}
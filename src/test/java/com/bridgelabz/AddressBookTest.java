package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookTest {
    AddressBook addressBook;
    List<AddressBookData> addressBookDataList;

    @Test
    public void givenThreeContactsInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        addressBook = new AddressBook();
        //Assertions.assertEquals(3, addressBookDataList.size());
        Assertions.assertEquals(4,  addressBook.readAddressBookData(AddressBook.IOService.DB_IO).size());
    }
}

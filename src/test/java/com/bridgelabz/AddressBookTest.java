package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class AddressBookTest {
    AddressBook addressBook;
    List<AddressBookData> addressBookDataList;

    @Test
    public void givenThreeContactsInDB_WhenRetrieved_ShouldMatchEmployeeCount() throws SQLException {
        addressBook = new AddressBook();
        //Assertions.assertEquals(3, addressBookDataList.size());
        Assertions.assertEquals(4,  addressBook.readAddressBookData(AddressBook.IOService.DB_IO).size());
    }
    @Test
    public void givenContactDataInDB_whenUpdated_ShouldSyncWithDB() throws SQLException {
        addressBook = new AddressBook();
        addressBookDataList = addressBook.readAddressBookData(AddressBook.IOService.DB_IO);
        addressBook.updateContact("ShivamRoad", "Bhavani");
        boolean result = addressBook.checkAddressBookInSyncWithDB("Bhavani");
        Assertions.assertTrue(result);
    }
    @Test
    public void givenDateRange_WhenContact_ShouldReturnEmpCount() throws SQLException{
        addressBook = new AddressBook();
        addressBookDataList = addressBook.readAddressBookData(AddressBook.IOService.DB_IO);
        LocalDate startDate = LocalDate.of(2018, 02, 01);
        LocalDate endDate = LocalDate.now();
        addressBookDataList = addressBook.readPersonDataForDateRange(startDate, endDate);
        Assertions.assertEquals(2, addressBookDataList.size());
    }
}

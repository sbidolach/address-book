package com.gumtree.book.service;

import com.gumtree.book.exception.AddressBookNoFoundException;
import com.gumtree.book.file.FileParser;
import com.gumtree.book.model.AddressBook;
import com.gumtree.book.model.Gender;
import com.gumtree.book.utils.DateUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchServiceImplTest {

    private SearchService searchService;
    private FileParser fileParser;

    @Before
    public void setUp() throws Exception {
        fileParser = mock(FileParser.class);
        searchService = new SearchServiceImpl(fileParser);
        when(fileParser.readDataFromFile()).thenReturn(new ArrayList<AddressBook>(){{
            add(new AddressBook("Bill McKnight", Gender.MALE, DateUtils.parseDateString("16/03/77")));
            add(new AddressBook("Paul Robinson", Gender.MALE, DateUtils.parseDateString("15/01/85")));
            add(new AddressBook("Gemma Lane", Gender.FEMALE, DateUtils.parseDateString("20/11/91")));
            add(new AddressBook("Sarah Stone", Gender.FEMALE, DateUtils.parseDateString("20/09/80")));
            add(new AddressBook("Wes Jackson", Gender.MALE, DateUtils.parseDateString("14/08/74")));
        }});
    }

    @Test
    public void countGenderByTypeOK() {
        assertEquals(3, searchService.countGenderByType(Gender.MALE));
    }

    @Test
    public void findTheOldestPersonOK() {
        AddressBook theOldestPerson = searchService.findTheOldestPerson();
        assertNotNull(theOldestPerson);
        assertEquals("Wes Jackson", theOldestPerson.getFullName());
        assertEquals(Gender.MALE, theOldestPerson.getGender());
        assertEquals(DateUtils.parseDateString("14/08/74"), theOldestPerson.getDateOfBirth());
    }

    @Test
    public void findTheOldestPersonWhenAddressBookIsEmpty() {
        when(fileParser.readDataFromFile()).thenReturn(new ArrayList<>());
        AddressBook theOldestPerson = searchService.findTheOldestPerson();
        assertNull(theOldestPerson);
    }

    @Test
    public void calculateDaysBetweenTwoPeopleDateOfBirthOK() throws AddressBookNoFoundException {
        assertEquals(-2862, searchService.calculateDaysBetweenTwoPeopleDateOfBirth("Bill McKnight", "Paul Robinson"));
    }

    @Test (expected = AddressBookNoFoundException.class)
    public void calculateDaysBetweenTwoPeopleDateOfBirthNoFoundException() throws Exception {
        searchService.calculateDaysBetweenTwoPeopleDateOfBirth("No Found", "Paul Robinson");
    }
}
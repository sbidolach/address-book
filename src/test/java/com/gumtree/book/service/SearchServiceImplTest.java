package com.gumtree.book.service;

import com.gumtree.book.file.FileParser;
import com.gumtree.book.model.AddressBook;
import com.gumtree.book.model.Gender;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

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
            add(new AddressBook("Bill McKnight", Gender.MALE, new Date()));
            add(new AddressBook("Paul Robinson", Gender.MALE, new Date()));
            add(new AddressBook("Gemma Lane", Gender.FEMALE, new Date()));
            add(new AddressBook("Sarah Stone", Gender.FEMALE, new Date()));
            add(new AddressBook("Wes Jackson", Gender.MALE, new Date()));
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
        assertEquals(new Date(), theOldestPerson.getDateOfBirth());
    }

    @Test
    public void calculateDaysBetweenTwoPeopleDateOfBirthOK() {
        assertEquals(2862, searchService.calculateDaysBetweenTwoPeopleDateOfBirth("Bill McKnight", "Paul Robinson"));
    }
}
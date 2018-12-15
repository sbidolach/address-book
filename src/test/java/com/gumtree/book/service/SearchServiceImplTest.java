package com.gumtree.book.service;

import com.gumtree.book.model.AddressBook;
import com.gumtree.book.model.Gender;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchServiceImplTest {

    private SearchService searchService;

    @Before
    public void setUp() throws Exception {
        this.searchService = new SearchServiceImpl();
    }

    @Test
    public void countGenderByTypeOK() {
        assertEquals(3, searchService.countGenderByType(Gender.MALE));
    }

    @Test
    public void findTheOldestPersonOK() {
        AddressBook theOldestPerson = searchService.findTheOldestPerson();
        assertNotNull(theOldestPerson);
        assertEquals("", theOldestPerson.getFullName());
        assertEquals("", theOldestPerson.getGender());
        assertEquals("", theOldestPerson.getGender());
    }

    @Test
    public void calculateDaysBetweenTwoPeopleDateOfBirthOK() {
        assertEquals(2862, searchService.calculateDaysBetweenTwoPeopleDateOfBirth("Bill McKnight", "Paul Robinson"));
    }
}
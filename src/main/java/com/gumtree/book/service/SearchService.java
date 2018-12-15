package com.gumtree.book.service;

import com.gumtree.book.exception.AddressBookNoFoundException;
import com.gumtree.book.model.AddressBook;
import com.gumtree.book.model.Gender;

public interface SearchService {

    /**
     * This method return number of selected type of gender
     *
     * @param gender
     * @return number of genders
     */
    int countGenderByType(final Gender gender);

    /**
     * This method return the oldest person from the address book
     *
     * @return the oldest person
     */
    AddressBook findTheOldestPerson();

    /**
     * This method calculate days between two dates of birth from selected people
     *
     * @param fullName1
     * @param fullName2
     * @return number of days
     * @throws AddressBookNoFoundException
     */
    long calculateDaysBetweenTwoPeopleDateOfBirth(final String fullName1, final String fullName2) throws AddressBookNoFoundException;

}

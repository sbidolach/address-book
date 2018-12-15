package com.gumtree.book.service;

import com.gumtree.book.file.FileParser;
import com.gumtree.book.model.AddressBook;
import com.gumtree.book.model.Gender;

public class SearchServiceImpl implements SearchService {

    private FileParser fileParser;

    public SearchServiceImpl(FileParser fileParser) {
        this.fileParser = fileParser;
    }

    @Override
    public int countGenderByType(Gender gender) {
        return 0;
    }

    @Override
    public AddressBook findTheOldestPerson() {
        return null;
    }

    @Override
    public long calculateDaysBetweenTwoPeopleDateOfBirth(String fullName1, String fullName2) {
        return 0;
    }

}

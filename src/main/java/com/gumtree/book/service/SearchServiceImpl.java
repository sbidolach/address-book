package com.gumtree.book.service;

import com.gumtree.book.file.FileParser;
import com.gumtree.book.model.AddressBook;
import com.gumtree.book.model.Gender;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchServiceImpl implements SearchService {

    private FileParser fileParser;

    public SearchServiceImpl(FileParser fileParser) {
        this.fileParser = fileParser;
    }

    @Override
    public int countGenderByType(Gender gender) {
        return fileParser.readDataFromFile().stream()
                .filter(addressBook -> addressBook.getGender().equals(gender))
                .collect(Collectors.toList()).size();
    }

    @Override
    public AddressBook findTheOldestPerson() {
        List<AddressBook> addressBookSorted = new ArrayList<>(fileParser.readDataFromFile());
        if (addressBookSorted.isEmpty()) {
            return null;
        } else {
            addressBookSorted.sort(Comparator.comparing(AddressBook::getDateOfBirth));
            return addressBookSorted.get(0);
        }
    }

    @Override
    public long calculateDaysBetweenTwoPeopleDateOfBirth(String fullName1, String fullName2) {
        return 0;
    }

}

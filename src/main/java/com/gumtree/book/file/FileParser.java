package com.gumtree.book.file;

import com.gumtree.book.model.AddressBook;

import java.util.List;

public interface FileParser {

    List<AddressBook> readDataFromFile();

}

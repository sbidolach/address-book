package com.gumtree.book.model;

import com.sun.istack.internal.NotNull;

import java.util.Date;

public class AddressBook {

    @NotNull
    private String fullName;

    @NotNull
    private Gender gender;

    @NotNull
    private Date dateOfBirth;

    public AddressBook(String fullName, Gender gender, Date dateOfBirth) {
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

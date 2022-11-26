package org.acme;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private String emptyString;
    private String nullString;

    public String getEmptyString() {
        return emptyString;
    }

    public void setEmptyString(String emptyString) {
        this.emptyString = emptyString;
    }

    public List<Integer> getListOfInts() {
        return listOfInts;
    }

    public void setListOfInts(List<Integer> listOfInts) {
        this.listOfInts = listOfInts;
    }

    private List<Integer> listOfInts = new ArrayList();


    public Person(String firstName, String lastName, String emptyString, String nullString, List<Integer> listOfInts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emptyString = emptyString;
        this.nullString = nullString;
        this.listOfInts = listOfInts;
        this.listOfInts.add(20);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNullString() {
        return nullString;
    }

    public void setNullString(String nullString) {
        this.nullString = nullString;
    }
}

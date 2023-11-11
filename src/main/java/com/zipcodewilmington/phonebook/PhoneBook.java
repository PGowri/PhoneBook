package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<String, List<String>>();
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String > phoneNumbers = new ArrayList<String>();
        phoneNumbers.add(phoneNumber);
        this.phonebook.put(name, phoneNumbers);
    }

    public void addAll(String name, String... phoneNumbers) {
        ArrayList<String > phone = new ArrayList<String>();
        for (String number: phoneNumbers){
            phone.add(number);
        }
        this.phonebook.put(name, phone);
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);

    }

    public Boolean hasEntry(String name, String phoneNumber) {
       // return phonebook.containsKey(name) || phonebook.containsValue(phoneNumber);
         return phonebook.get(name).contains(phoneNumber);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for(String name : phonebook.keySet()){
            if(phonebook.get(name).contains(phoneNumber)){
                return name;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        ArrayList<String> allNames = new ArrayList<>();
        for(String name : phonebook.keySet()) {
            allNames.add(name);
        }
        return allNames;
    }

    public Map<String, List<String>> getMap() {
        return new LinkedHashMap<String, List<String>>();
    }
}

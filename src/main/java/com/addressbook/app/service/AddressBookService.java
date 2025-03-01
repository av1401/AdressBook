package com.addressbook.app.service;

import com.addressbook.app.dto.AddressBookDTO;
import com.addressbook.app.exception.AddressBookException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AddressBookService {
    private final List<AddressBookDTO> addressBookList = new ArrayList<>();

    public void addContact(AddressBookDTO contact) {
        log.info("Adding contact: {}", contact);
        addressBookList.add(contact);
    }

    public List<AddressBookDTO> getAllContacts() {
        log.info("Fetching all contacts");
        return addressBookList;
    }

    public AddressBookDTO getContactById(int id) {
        log.info("Fetching contact with ID: {}", id);
        if (id >= 0 && id < addressBookList.size()) {
            return addressBookList.get(id);
        } else {
            throw new AddressBookException("Address Book Entry with ID " + id + " not found!");
        }
    }

    public void updateContact(int id, AddressBookDTO contact) {
        log.info("Updating contact with ID: {}", id);
        if (id >= 0 && id < addressBookList.size()) {
            addressBookList.set(id, contact);
        } else {
            throw new AddressBookException("Address Book Entry with ID " + id + " not found!");
        }
    }

    public void deleteContact(int id) {
        log.info("Deleting contact with ID: {}", id);
        if (id >= 0 && id < addressBookList.size()) {
            addressBookList.remove(id);
        } else {
            throw new AddressBookException("Address Book Entry with ID " + id + " not found!");
        }
    }
}

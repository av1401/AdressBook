package com.addressbook.app.service;

import com.addressbook.app.dto.AddressBookDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AddressBookService {
    private final List<AddressBookDTO> contacts = new ArrayList<>();

    public List<AddressBookDTO> getAllContacts() {
        log.info("Fetching all contacts");
        return contacts;  // Now returning a List<AddressBookDTO>
    }

    public void addContact(AddressBookDTO contact) {
        contacts.add(contact);
        log.info("Added contact: {}", contact);
    }
}

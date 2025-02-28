package com.addressbook.app.service;

import com.addressbook.app.dto.AddressBookDTO;
import com.addressbook.app.model.AddressBookEntry;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService {

    // Method to create AddressBookEntry from DTO
    public AddressBookEntry createAddressBookEntry(AddressBookDTO dto) {
        return new AddressBookEntry(1L, dto.getName(), dto.getEmail(), dto.getPhone(), "Default Address");
    }
}

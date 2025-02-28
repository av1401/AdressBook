package com.addressbook.app.controller;

import com.addressbook.app.dto.AddressBookDTO;
import com.addressbook.app.model.AddressBookEntry;
import com.addressbook.app.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired  // ✅ Inject Service Layer
    private AddressBookService addressBookService;

    // ✅ REST API to create AddressBook Entry
    @PostMapping("/contacts")
    public ResponseEntity<AddressBookEntry> createContact(@RequestBody AddressBookDTO dto) {
        AddressBookEntry entry = addressBookService.createAddressBookEntry(dto);
        return ResponseEntity.ok(entry);
    }
}

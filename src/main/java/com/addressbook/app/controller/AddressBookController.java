package com.addressbook.app.controller;

import com.addressbook.app.dto.AddressBookDTO;
import com.addressbook.app.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    private final AddressBookService addressBookService;

    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }
    //Get mapping for contacts

    @GetMapping("/contacts")
    public ResponseEntity<List<AddressBookDTO>> getAllContacts() {
        List<AddressBookDTO> contacts = addressBookService.getAllContacts();
        return ResponseEntity.ok(contacts);  // Correct type now
    }

    @PostMapping("/contacts")
    public ResponseEntity<String> addContact(@RequestBody AddressBookDTO contact) {
        addressBookService.addContact(contact);
        return ResponseEntity.ok("Contact added successfully");
    }
}

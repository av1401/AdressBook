package com.addressbook.app.controller;

import com.addressbook.app.dto.AddressBookDTO;
import com.addressbook.app.service.AddressBookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    private final AddressBookService addressBookService;

    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    @PostMapping("/contacts")
    public ResponseEntity<String> addContact(@Valid @RequestBody AddressBookDTO contact) {
        addressBookService.addContact(contact);
        return ResponseEntity.ok("Contact added successfully");
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<AddressBookDTO>> getAllContacts() {
        List<AddressBookDTO> contacts = addressBookService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<?> getContactById(@PathVariable int id) {
        AddressBookDTO contact = addressBookService.getContactById(id);
        if (contact != null) {
            return ResponseEntity.ok(contact);
        } else {
            return ResponseEntity.badRequest().body("Contact not found");
        }
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity<String> updateContact(@PathVariable int id, @Valid @RequestBody AddressBookDTO contact) {
        addressBookService.updateContact(id, contact);
        return ResponseEntity.ok("Contact updated successfully");
    }

    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        addressBookService.deleteContact(id);
        return ResponseEntity.ok("Contact deleted successfully");
    }
}

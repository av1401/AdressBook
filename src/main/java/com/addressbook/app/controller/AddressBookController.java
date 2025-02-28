package com.addressbook.app.controller;

import com.addressbook.app.dto.AddressBookDTO;
import com.addressbook.app.service.AddressBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    private final AddressBookService service;

    public AddressBookController(AddressBookService service) {
        this.service = service;
    }

    //  GET all contacts
    @GetMapping("/contacts")
    public ResponseEntity<List<AddressBookDTO>> getAllContacts() {
        return service.getAllContacts();
    }

    // GET contact by ID
    @GetMapping("/contacts/{id}")
    public ResponseEntity<AddressBookDTO> getContactById(@PathVariable Long id) {
        return service.getContactById(id);
    }

    //  POST - Add new contact
    @PostMapping("/contacts")
    public ResponseEntity<AddressBookDTO> addContact(@RequestBody AddressBookDTO dto) {
        return service.addContact(dto);
    }

    //  PUT - Update contact by ID
    @PutMapping("/contacts/{id}")
    public ResponseEntity<AddressBookDTO> updateContact(@PathVariable Long id, @RequestBody AddressBookDTO dto) {
        return service.updateContact(id, dto);
    }

    //  DELETE - Remove contact by ID
    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        return service.deleteContact(id);
    }
}

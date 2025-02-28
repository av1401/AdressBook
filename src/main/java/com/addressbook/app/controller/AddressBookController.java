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

    @GetMapping("/contacts")
    public ResponseEntity<List<AddressBookDTO>> getAllContacts() {
        return service.getAllContacts();
    }

    @PostMapping("/contacts")
    public ResponseEntity<AddressBookDTO> addContact(@RequestBody AddressBookDTO dto) {
        return service.addContact(dto);
    }
}

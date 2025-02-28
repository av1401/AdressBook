package com.addressbook.app.service;

import com.addressbook.app.dto.AddressBookDTO;
import com.addressbook.app.model.AddressBookEntry;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class AddressBookService {
    private final List<AddressBookEntry> contacts = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    //  GET all contacts
    public ResponseEntity<List<AddressBookDTO>> getAllContacts() {
        List<AddressBookDTO> contactDTOs = contacts.stream()
                .map(entry -> new AddressBookDTO(entry.getName(), entry.getEmail(), entry.getPhone()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(contactDTOs);
    }

    //  GET contact by ID
    public ResponseEntity<AddressBookDTO> getContactById(Long id) {
        Optional<AddressBookEntry> contact = contacts.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst();

        return contact.map(entry -> ResponseEntity.ok(
                        new AddressBookDTO(entry.getName(), entry.getEmail(), entry.getPhone())))
                .orElse(ResponseEntity.notFound().build());
    }

    //  POST - Add new contact
    public ResponseEntity<AddressBookDTO> addContact(AddressBookDTO dto) {
        AddressBookEntry entry = new AddressBookEntry(
                idCounter.getAndIncrement(), dto.getName(), dto.getEmail(), dto.getPhone(), "Default Address"
        );

        contacts.add(entry);
        return ResponseEntity.ok(dto);
    }

    //  PUT - Update contact by ID
    public ResponseEntity<AddressBookDTO> updateContact(Long id, AddressBookDTO updatedDto) {
        for (AddressBookEntry entry : contacts) {
            if (entry.getId().equals(id)) {
                entry.setName(updatedDto.getName());
                entry.setEmail(updatedDto.getEmail());
                entry.setPhone(updatedDto.getPhone());
                return ResponseEntity.ok(updatedDto);
            }
        }
        return ResponseEntity.notFound().build();
    }

    //  DELETE - Remove contact by ID
    public ResponseEntity<String> deleteContact(Long id) {
        boolean removed = contacts.removeIf(entry -> entry.getId().equals(id));
        if (removed) {
            return ResponseEntity.ok("Contact deleted successfully.");
        }
        return ResponseEntity.notFound().build();
    }
}

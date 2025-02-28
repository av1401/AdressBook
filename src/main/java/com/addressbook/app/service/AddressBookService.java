package com.addressbook.app.service;

import com.addressbook.app.dto.AddressBookDTO;
import com.addressbook.app.model.AddressBookEntry;
import com.addressbook.app.repository.AddressBookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBookService {

    private final AddressBookRepository repository;

    public AddressBookService(AddressBookRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<AddressBookDTO>> getAllContacts() {
        List<AddressBookDTO> contacts = repository.findAll().stream()
                .map(entry -> AddressBookDTO.builder()
                        .name(entry.getName())
                        .email(entry.getEmail())
                        .phone(entry.getPhone())
                        .build()
                )
                .collect(Collectors.toList());

        return ResponseEntity.ok(contacts);
    }

    public ResponseEntity<AddressBookDTO> addContact(AddressBookDTO dto) {
        AddressBookEntry entry = AddressBookEntry.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .address("Default Address") // Can be updated later
                .build();

        repository.save(entry);

        return ResponseEntity.ok(dto);
    }
}

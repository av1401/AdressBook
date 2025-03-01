package com.addressbook.app.dto;

import lombok.Data;

@Data  // Lombok annotation to generate getters and setters
public class AddressBookDTO {
    private String name;
    private String email;
    private String phone;

    public AddressBookDTO(String name, String email, String phone) {
    }
}

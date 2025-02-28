package com.addressbook.app.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressBookDTO {
    private String name;
    private String email;
    private String phone;
}
